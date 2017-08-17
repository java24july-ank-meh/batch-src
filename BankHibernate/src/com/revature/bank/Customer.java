package com.revature.bank;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	private long cid;
	@Column
	private String fname;
	@Column
	private String lname;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name="cid")
	private Set<BankAccount> accounts;
	
	
	public Customer(){}
	public Customer(long cid, String fname, String lname) {
		super();
		this.cid = cid;
		this.fname = fname;
		this.lname = lname;
	}
	
	public Set<BankAccount> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<BankAccount> accounts) {
		this.accounts = accounts;
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

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", fname=" + fname + ", lname=" + lname + ", accounts=" + accounts + "]";
	}
	
	
}
