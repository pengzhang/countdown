package models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;
import utils.AppConfig;
import utils.SendUtils;

@Entity
@Table(name="email")
public class Email extends Model {
	
	private static final long serialVersionUID = 1L;
	@Id
	public long id;
	public String email;
	public boolean is_send = false;
	public Timestamp create_at = new Timestamp(System.currentTimeMillis());
	public Timestamp send_at ;
	
	public static Model.Finder<Long, Email> find = new Model.Finder<Long, Email>(Long.class, Email.class);
	
	public static void createEmail(Email e) {
		e.save();
	}

	public static void modifyEmail(Email e) {
		e.id = getEmail(e.email).id;
		e.update();
	}

	public static Email getEmail(String email) {
		return find.where().eq("email", email).findUnique();
	}

	public static Email getEmail(long id) {
		return find.byId(id);
	}

	public static List<Email> getEmai(int page, int size) {
		return find.findPagingList(size).getPage(page).getList();
	}
	
	public static List<Email> getEmaiAll() {
		return find.all();
	}
	
	public static void updateSendStatus(String email){
		Email emailBean = getEmail(email);
		emailBean.send_at = (new Timestamp(System.currentTimeMillis()));
		emailBean.is_send = true;
		modifyEmail(emailBean);
	}
	
	public static boolean subscriptEmail(String email){
		Email e = getEmail(email);
		if( e== null){
			Email emailBean =new Email();
			emailBean.email = email;
			createEmail(emailBean);
			SendUtils.mail(email, AppConfig.SubScript_Subject, AppConfig.SubScript_Content);
			updateSendStatus(email);
			return true;
		}else if(!e.is_send){
			SendUtils.mail(email, AppConfig.SubScript_Subject, AppConfig.SubScript_Content);
			updateSendStatus(email);
			return true;
		}
		return false;
	}

}
