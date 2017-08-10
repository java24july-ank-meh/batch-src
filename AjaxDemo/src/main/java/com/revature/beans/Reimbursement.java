package com.revature.beans;

public class Reimbursement {

	private int rid;
	private String fname;
	private String lname;
	private String type;
	private String status;

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Reimbursement(int rid, String fname, String lname, String type, String status) {
		super();
		this.rid = rid;
		this.fname = fname;
		this.lname = lname;
		this.type = type;
		this.status = status;
	}

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Reimbursement [rid=" + rid + ", fname=" + fname + ", lname=" + lname + ", type=" + type + ", status="
				+ status + "]";
	}

}
