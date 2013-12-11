package utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

import play.Logger;


/**
 * 发送工具类
 * 1.发送邮件
 * 2.发送短信息
 * 3.发送站内信
 * @author zhangpeng
 *
 */
public class SendUtils {
	
	/**
	 * 发送邮件(单封)
	 * @param email
	 * @param subject
	 * @param content
	 * @throws EmailException 
	 */
	public static void mail(String uemail, String subject, String content) {
		try {
			Email email = new SimpleEmail();
			email.setHostName(AppConfig.Email_Host);
			email.setSmtpPort(AppConfig.Email_Port);
			email.setAuthenticator(new DefaultAuthenticator(AppConfig.Email_Username, AppConfig.Email_Password));
			email.setSSLOnConnect(true);
			email.setFrom(AppConfig.Email_Email,AppConfig.Eamil_ShowName);
			email.setSubject(subject);
			email.setCharset("utf-8");
			email.setMsg(content);
			email.addTo(uemail);
			email.send();
		} catch (EmailException e) {
			Logger.info("send mail failure");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 发送电子邮件HTML格式(单封)
	 * @param uemail
	 * @param subject
	 * @param htmlMsg
	 * @param textMsg
	 * @throws EmailException
	 */
	public static void mailHtml(String uemail, String subject, String htmlMsg, String textMsg) {
		
		try {
			HtmlEmail email = new HtmlEmail();
			email.setHostName(AppConfig.Email_Host);
			email.setSmtpPort(AppConfig.Email_Port);
			email.setAuthenticator(new DefaultAuthenticator(AppConfig.Email_Username, AppConfig.Email_Password));
			email.setSSLOnConnect(true);
			email.addTo(uemail);
			email.setFrom(AppConfig.Email_Email, AppConfig.Eamil_ShowName);
			email.setCharset("utf-8");
			email.setSubject(subject);
			email.setHtmlMsg(htmlMsg);
			email.setTextMsg(textMsg);
			email.send();
		} catch (EmailException e) {
			Logger.info("send html email failure");
			e.printStackTrace();
		}
	}
}
