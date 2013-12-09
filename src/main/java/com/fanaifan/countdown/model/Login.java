package com.fanaifan.countdown.model;

import com.fanaifan.countdown.utils.ConfigUtil;

public class Login {
	
	public static boolean login(String username,String password){
		String uname = ConfigUtil.readValue("username");
		String upwd = ConfigUtil.readValue("password");
		if(username.equals(uname) && password.equals(upwd)){
			return true;
		}
		return false;
	}

}
