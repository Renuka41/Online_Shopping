package com.dxc.pojos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sno", updatable = false, nullable = false)
	private int sno;
	private int id;
	private int Quantity;
	
	private int cid;
	
	public Cart() {}

	public Cart(int sno, int id, int quantity, int cid) {
		super();
		this.sno = sno;
		this.id = id;
		Quantity = quantity;
		this.cid = cid;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Cart [sno=" + sno + ", id=" + id + ", Quantity=" + Quantity + ", cid=" + cid + "]";
	}
	
	
}
