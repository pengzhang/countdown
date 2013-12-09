package com.fanaifan.countdown.utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;


/**
 * 发送工具类
 * 1.发送邮件
 * 2.发送短信息
 * 3.发送站内信
 * @author zhangpeng
 *
 */
public class SendUtils {
	
	public static Logger log = Logger.getLogger(SendUtils.class);
	
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
			email.setHostName(ConfigUtil.readValue("email_host"));
			email.setSmtpPort(Integer.parseInt(ConfigUtil.readValue("email_port")));
			email.setAuthenticator(new DefaultAuthenticator(ConfigUtil.readValue("email_username"), ConfigUtil.readValue("email_password")));
			email.setSSLOnConnect(true);
			email.setFrom(ConfigUtil.readValue("email_email"),ConfigUtil.readValue("email_showname"));
			email.setSubject(subject);
			email.setCharset("utf-8");
			email.setMsg(content);
			email.addTo(uemail);
			email.send();
		} catch (EmailException e) {
			log.info("send "+uemail+" failure, try again...");
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
	public static void mailHtml(String uemail, String subject, String htmlMsg, String textMsg) throws EmailException{
		HtmlEmail email = new HtmlEmail();
		email.setHostName(ConfigUtil.readValue("email_host"));
		email.setSmtpPort(Integer.parseInt(ConfigUtil.readValue("email_port")));
		email.setAuthenticator(new DefaultAuthenticator(ConfigUtil.readValue("email_username"), ConfigUtil.readValue("email_password")));
		email.setSSLOnConnect(true);
		email.addTo(uemail);
		email.setFrom(ConfigUtil.readValue("email_email"), ConfigUtil.readValue("email_showname"));
		email.setCharset("utf-8");
		email.setSubject(subject);
		email.setHtmlMsg(htmlMsg);
		email.setTextMsg(textMsg);
		email.send();
	}
	
	
}
