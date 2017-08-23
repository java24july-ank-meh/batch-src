package com.revature.spring.hib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Repository;

@Repository
@Entity
public class Teacher {

	@Id
	private long tid;
	@Column
	private String fname;
	private String lname;
	private long classCode;
	
	public Teacher(){}
	public Teacher(long tid, String fname, String lname, long classCode) {
		super();
		this.tid = tid;
		this.fname = fname;
		this.lname = lname;
		this.classCode = classCode;
	}
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
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
	public long getClassCode() {
		return classCode;
	}
	public void setClassCode(long classCode) {
		this.classCode = classCode;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", fname=" + fname + ", lname=" + lname + ", classCode=" + classCode + "]";
	}
	
	
}
