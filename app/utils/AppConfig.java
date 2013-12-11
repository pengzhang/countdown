package utils;

import play.Play;


public class AppConfig {

	/**
	 * Email SMTP 主机
	 */
	public static String Email_Host = getConfig("email.host");
	
	/**
	 * Email SMTP 端口
	 */
	public static int Email_Port = Integer.parseInt(getConfig("email.port"));
	
	/**
	 * Email 用户名
	 */
	public static String Email_Username = getConfig("email.username");
	
	/**
	 * Email 密码
	 */
	public static String Email_Password = getConfig("email.password");
	
	/**
	 * Email 电子邮件
	 */
	public static String Email_Email = getConfig("email.email");
	
	/**
	 * Email 邮件中显示名称
	 */
	public static String Eamil_ShowName = getConfig("email.showname");
	
	/**
	 * 订阅-邮件主题
	 */
	public static String SubScript_Subject = getConfig("subscript.subject");
	
	/**
	 * 订阅-邮件内容
	 */
	public static String SubScript_Content = getConfig("subscript.content");
	
	/**
	 *  应用Context
	 * @param config
	 * @return
	 */
	
	public static String AppContext = getConfig("application.context")==null || getConfig("application.context").equals("null") || getConfig("application.context").equals("")?"":getConfig("application.context");
	
	
	public static String redirectURL(String url){
		if(!url.startsWith("/")){
			return AppContext + "/" +url;
		}
		return AppContext + url;
	}
			
	private static String getConfig(String config){
		return Play.application().configuration().getString(config);
	}
}
