package com.fanaifan.countdown.service;

import java.sql.Timestamp;
import java.util.List;

import com.avaje.ebean.Ebean;
import com.fanaifan.countdown.model.Email;
import com.fanaifan.countdown.utils.ConfigUtil;
import com.fanaifan.countdown.utils.SendUtils;

public class EmailService {

	public static void createEmail(Email e) {
		Ebean.save(e);
	}

	public static void modifyEmail(Email e) {
		Ebean.update(e);
	}

	public static Email getEmail(String email) {
		return Ebean.find(Email.class).where().eq("email", email).findUnique();
	}

	public static Email getEmail(long id) {
		return Ebean.find(Email.class, id);
	}

	public static List<Email> getEmai(int page, int size) {
		return Ebean.find(Email.class).findPagingList(size).getPage(page).getList();
	}
	
	public static List<Email> getEmaiAll() {
		return Ebean.find(Email.class).findList();
	}
	
	public static void updateSendStatus(String email){
		Email emailBean = getEmail(email);
		emailBean.setSend_at(new Timestamp(System.currentTimeMillis()));
		emailBean.setIs_send(true);
		modifyEmail(emailBean);
	}
	
	public static boolean subscriptEmail(String email){
		Email e = EmailService.getEmail(email);
		if( e== null){
			Email emailBean =new Email();
			emailBean.setEmail(email);
			EmailService.createEmail(emailBean);
			SendUtils.mail(email, ConfigUtil.readValue("subscript_subject"), ConfigUtil.readValue("subscript_content"));
			updateSendStatus(email);
			return true;
		}else if(!e.isIs_send()){
			SendUtils.mail(email, ConfigUtil.readValue("subscript_subject"), ConfigUtil.readValue("subscript_content"));
			updateSendStatus(email);
			return true;
		}
		return false;
	}

	public static boolean resendEmail(long id) {
		Email e = EmailService.getEmail(id);
		if(!e.isIs_send()){
			SendUtils.mail(e.getEmail(), ConfigUtil.readValue("subscript_subject"), ConfigUtil.readValue("subscript_content"));
			updateSendStatus(e.getEmail());
			return true;
		}
		return false;
	}
	
	

}
