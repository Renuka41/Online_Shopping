package com.dxc.pojos;

import javax.persistence.Entity;

@Entity
public class Wallet {
	private int cid;
	private double balance;
	public Wallet(int cid, double balance) {
		super();
		this.cid = cid;
		this.balance = balance;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Wallet [cid=" + cid + ", balance=" + balance + "]";
	}
	

}
