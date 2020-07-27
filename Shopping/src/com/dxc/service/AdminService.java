package com.dxc.service;

import java.util.List;

import com.dxc.dao.AdminDao;
import com.dxc.pojos.Admin;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;

public class AdminService {

	AdminDao dao=new AdminDao();

	public void addAdmin(Admin a)
	{
		dao.addAdmin(a);

	}
	public boolean login(Admin a) {
	return dao.login(a);
	}
	public void addproduct(Product p) {
		dao.addproduct(p);
	}
	public boolean remove(int cid)
	{
		  return dao.remove(cid);
	}
	public void delete(int id)
	{
		dao.delete(id);
	}
	public void addcustomer(Customer c) {
		dao.addcustomer(c);
	}
	public List<Product> display(){
return dao.display();
	
	}
	public List<Customer> show(){
		return dao.show();
			
			}
	
	
}