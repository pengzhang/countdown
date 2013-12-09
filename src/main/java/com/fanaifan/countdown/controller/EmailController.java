package com.fanaifan.countdown.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fanaifan.countdown.model.Email;
import com.fanaifan.countdown.service.EmailService;

@Path("/meng-cms")
public class EmailController {
	
	@Path("/subscript")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String subscript(Email e){
		if(EmailService.subscriptEmail(e.getEmail())){
			return "{\"status\":\"success\"}";
		}
		return "{\"status\":\"failure\"}";
	}
	
	@Path("/send/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String resend(@PathParam("id") long id){
		if(EmailService.resendEmail(id)){
			return "{\"status\":\"success\"}";
		}
		return "{\"status\":\"failure\"}";
	}

}
