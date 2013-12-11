package models;

import utils.AppConfig;


public class Login {
	
	public static boolean login(String username,String password){
		String uname = AppConfig.Email_Username;
		String upwd = AppConfig.Email_Password;
		if(username.equals(uname) && password.equals(upwd)){
			return true;
		}
		return false;
	}

}
