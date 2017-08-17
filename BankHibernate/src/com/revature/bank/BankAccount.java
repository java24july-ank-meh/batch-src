package com.revature.bank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BankAccount {

	@Id
	private long acct;
	@Column
	private String type;
	@Column
	private double balance;
	
	@ManyToOne
	@JoinColumn(name="cid")
	private Customer customer;
	
	public BankAccount(){}
	public BankAccount(long acct, String type, double balance, Customer customer) {
		super();
		this.acct = acct;
		this.type = type;
		this.balance = balance;
		this.customer = customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public long getAcct() {
		return acct;
	}
	public void setAcct(long acct) {
		this.acct = acct;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankAccount [acct=" + acct + ", type=" + type + ", balance=" + balance + "]";
	}
	
	
}
