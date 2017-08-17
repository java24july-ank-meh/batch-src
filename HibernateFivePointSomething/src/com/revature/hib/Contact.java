package com.revature.hib;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contact {

	@Id
	private long cid;
	private String fname;
	private String lname;
	private long phone;
	private String email;
	
	public Contact(){}

	public Contact(long cid, String fname, String lname, long phone, String email) {
		super();
		this.cid = cid;
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.email = email;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
