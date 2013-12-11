package controllers;

import java.util.List;
import java.util.Map;

import models.Email;
import models.Login;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import utils.AppConfig;
import utils.StringUtils;
import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
        return redirect(AppConfig.redirectURL("/assets/index.html"));
    }
    
    public static Result send(String email){
    	 if(Email.subscriptEmail(email)){
    	 return ok(StringUtils.returnSuccess());
    	 }
    	 return ok(StringUtils.returnFailure());
    }
    
    public static Result login(	){
    	Map<String,String> map = DynamicForm.form().bindFromRequest().data();
    	String username = map.get("username");
    	String password = map.get("password");
    	boolean flag = Login.login(username, password);
    	if(flag){
    		session().put("username", username);
    		return controllers.Application.email_list();
    	}
    	return controllers.Application.index();
    }
    
    public static Result logout(){
    	session().clear();
    	return controllers.Application.index();
    }
    
    public static Result email_list(){
    	List<Email> emails = Email.getEmaiAll(); 
		return ok(show.render(emails));
    }
    
}
