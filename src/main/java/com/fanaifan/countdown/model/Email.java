package com.fanaifan.countdown.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="email")
public class Email {
	
	@Id
	private long id;
	private String email;
	private boolean is_send = false;
	private Timestamp create_at = new Timestamp(System.currentTimeMillis());
	private Timestamp send_at ;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isIs_send() {
		return is_send;
	}
	public void setIs_send(boolean is_send) {
		this.is_send = is_send;
	}
	public Timestamp getCreate_at() {
		return create_at;
	}
	public void setCreate_at(Timestamp create_at) {
		this.create_at = create_at;
	}
	public Timestamp getSend_at() {
		return send_at;
	}
	public void setSend_at(Timestamp send_at) {
		this.send_at = send_at;
	}
	
	
	
	

}
