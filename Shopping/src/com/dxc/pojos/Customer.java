package com.dxc.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Customer {
	@Id
	private int cid;
	private String name;
	private String pass;
	private double balance;
	
	public Customer() {}

	public Customer(int cid, String name, String pass, double balance) {
		super();
		this.cid = cid;
		this.name = name;
		this.pass = pass;
		this.balance = balance;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", pass=" + pass + ", balance=" + balance + "]";
	}
	
	

}
