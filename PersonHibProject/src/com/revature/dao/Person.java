package com.revature.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Entity
//@Table(name="PERSONINFO")
public class Person {

	@Id
	//@Column(name="PERSONID")
	@GeneratedValue(strategy=GenerationType.AUTO) //Auto increment
	private long pid;
	
	@Column
	//@Column(name="FIRSTNAME")
	private String fname;
	//@Column
	private String lname;
	//@Column
	private String email;
	
	public Person()
	{
		
	}
	
	//constructor with fields
	public Person(String fname, String lname, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}
	//setters and getters
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//toString
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", fname=" + fname + ", lname=" + lname + ", email=" + email + "]";
	}
	
	
}
