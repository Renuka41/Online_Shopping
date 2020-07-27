package com.dxc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;
public class AdminDao {
List<Admin> list=new ArrayList<>();
	private static SessionFactory sessionFactory;
	static{
		Configuration configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	public void addAdmin(Admin a)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
	}
	public boolean login(Admin a) 
	{
		Session session=sessionFactory.openSession();
		
		System.out.println("going to login");
		Query q1= session.createQuery("from Admin");

 list=q1.getResultList();
		for(int i=0;i<list.size();i++)
		{
		if(a.getId()==list.get(i).getId()&&a.getPassword().equalsIgnoreCase(list.get(i).getPassword()))
		{
			System.out.println("hhhhhh");
			return true;
		}
		}
	
	return false;	
		
	}
	public void addproduct(Product p)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	}	
	public boolean remove(int cid) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("going to delete");
		Query q1= session.createQuery("delete from  Customer where cid=:cid");
		System.out.println("deleted");
	q1.setParameter("cid",cid);
	q1.executeUpdate();
	session.getTransaction().commit();
	return true;
	}
	public void delete(int id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("going to delete");
		Query q1= session.createQuery("delete from  Product where id=:id");
		System.out.println("deleted");
	q1.setParameter("id",id);
	q1.executeUpdate();
	session.getTransaction().commit();
	}
	public void addcustomer(Customer c)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
	}
	public List<Product> display(){
	Session session=sessionFactory.openSession();
	Query q1=session.createQuery("from Product");
	return q1.getResultList();
	}
	public List<Customer> show(){
		Session session=sessionFactory.openSession();
		Query q6=session.createQuery("from Customer");
		return q6.getResultList();
		}
	
	

}
	
	
