package com.dxc.service;

import java.util.List;

import com.dxc.dao.CustomerDao;
import com.dxc.pojos.Cart;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;
import com.dxc.pojos.Wallet;

public class CustomerService {
	CustomerDao dao=new CustomerDao();
	
	public boolean passwordChange( int cid,String pass) {
        return dao.passwordChange(cid,pass);
    }
	public boolean customerlogin(Customer cs) {
		return dao.customerlogin(cs);
	}
	 public List<Product> availableProducts()
	   {
	      return dao.availableProducts();
	   }
	   
	   public boolean addproducttocart(int id,Cart c,int cid,Product p) 
	   {
		   return dao.addproducttocart(id,c, cid, p);
	   }
	   
	   public List<Cart> showCartProducts(int cid)
	   {
		   return dao.showCartProducts(cid);
	   }
	    public boolean walletBalance(Customer c, double balance, int cid) {
	    	return dao.walletBalance(c, balance, cid);
	    }
	    public boolean pay(int cid, int id, double payableAmmount) {
	        return dao.pay(cid,id,payableAmmount);
	    }
	    public List<Customer> showwallet(int cid)
		   {
			   return dao.showwallet(cid);
		   }
	     public Product getProduct(int id) {
	    	return dao.getProduct(id);
	     }


	  
}