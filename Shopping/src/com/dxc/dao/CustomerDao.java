package com.dxc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Cart;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;
import com.dxc.pojos.Wallet;

public class CustomerDao {
	List<Customer> list=new ArrayList<>();
	private static SessionFactory sessionFactory;
	static{
		Configuration configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	public boolean passwordChange( int cid,String pass) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query q1=session.createQuery("update Customer set pass=:pass where cid=:cid");
		q1.setParameter("pass", pass);
		q1.setParameter("cid", cid);
		q1.executeUpdate();
		session.getTransaction().commit();
		return true;
		
    }
	public boolean customerlogin(Customer cs) 
	{
		Session session=sessionFactory.openSession();
		
		System.out.println("going to customerlogin");
		Query q1= session.createQuery("from Customer");

 list=q1.getResultList();
		for(int i=0;i<list.size();i++)
		{
		if(cs.getCid()==list.get(i).getCid()&&cs.getPass().equalsIgnoreCase(list.get(i).getPass()))
		{
			System.out.println("customer login");
			return true;
		}
		}
	
	return false;	
		
	}
	 public List<Product> availableProducts()
	  {
		  Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
			  List<Product> list=query.getResultList();
			  System.out.println(list);
			  return list;
	  }
	 
	  public boolean addproducttocart(int id, Cart c,int cid,Product p) 
	  {  
	         c.setCid(cid);
	         System.out.println(c.getId());
	         System.out.println(c.getQuantity());
	         Session session4=sessionFactory.openSession();
	         Query query=session4.createQuery("from Cart");
	         List<Cart> list=query.getResultList();
	         int size=list.size();
	         int sno=0;
	         int index=1;
	         for(Cart cart:list)
	         {
	             if(size==index)
	             {
	                 sno=cart.getSno();
	             }
	             index++;
	         }
	         sno++;
	         c.setSno(sno);
	         session4.beginTransaction();
	         session4.save(c);
	         session4.getTransaction().commit();
	         if(isAvailable(id))
	         {
	         Session session=sessionFactory.openSession();
	         session.beginTransaction();
	         Query query1=session.createQuery("from Product where id=:id");
	         query1.setParameter("id",id);
	        
	         Session session1=sessionFactory.openSession();
	         session1.beginTransaction();
	         Query query2=session1.createQuery("from Cart  where id=:id and cid=:cid");
	         query2.setParameter("id",id);
	         query2.setParameter("cid",cid);
	         List<Cart> list2 = query2.getResultList();
	         
	         List<Product> list1=query1.getResultList();
	         for(Product pro:list1)
	         {
	             for(Cart c1: list2) {
	             if(c.getQuantity()<=pro.getQuantity())
	             {
	                 System.out.println();
	                 int quantity=pro.getQuantity()-c.getQuantity();
	                 Query query3=session.createQuery("update Product set quantity=:quantity where id=:id");
	                 query3.setParameter("quantity", quantity);
	                 query3.setParameter("id", c.getId());
	                 query3.executeUpdate();
	            
             }}
	         } session.getTransaction().commit();
	         session1.getTransaction().commit();
	         return true;
	         
	     }
	        return false;
	     }
	     
	     
	     
	     
	     public boolean isAvailable(int id)
	     {
	     Product p1=null;
	      Session session=sessionFactory.openSession();
	      Query query2=session.createQuery("from Product where id=:id");
	      query2.setParameter("id", id);
	      List<Product> list1=query2.getResultList();
	      try
	      {
	        p1=list1.get(0);
	          return true;
	      }
	      catch(Exception e)
	      {
	      return false;
	    }
	}
	     
	     public List<Cart> showCartProducts(int cid)
	      {
	          Session session=sessionFactory.openSession();
	        Query query=session.createQuery("from Cart where cid=:cid");
	         query.setParameter("cid",cid);

	 

	              List<Cart> list=query.getResultList();
	              System.out.println(list);
	              return list;
	          
	      }
	     
	     public Product getProduct(int id)
	     {
	         Session session=sessionFactory.openSession();
	            Query q1=session.createQuery("from Product where id=:id");
	            q1.setParameter("id",id);
	            List<Product> list=q1.getResultList();
	            for(Product p:list)
	            {
	                return p;
	            }
	        return null;
	     }
	    public boolean pay(int cid, int id, double payableAmmount) 
	    {
	        Session session=sessionFactory.openSession();
	        session.beginTransaction();
	        
	        Query q1=session.createQuery("from Customer where cid=:cid");
	        q1.setParameter("cid", cid);
	        List<Customer> list=q1.getResultList();
	        for(Customer cust:list)
	        {
	            double amount=cust.getBalance();
	            if(amount<payableAmmount)
	            {
	                return false;
	            }
	            amount=amount-payableAmmount;
	            Query q=session.createQuery("update Customer set balance=:balance where cid=:cid");
	            q.setParameter("balance",amount);
	            q.setParameter("cid", cid);
	            q.executeUpdate();
	        }
	        Query q2=session.createQuery("delete from Cart where cid=:cid AND  id=:id");
	        q2.setParameter("cid",cid);
	        q2.setParameter("id", id);
	        q2.executeUpdate();
	        session.getTransaction().commit();
	        
	        
	    
	        return true;
	    }
	     
	    public boolean walletBalance(Customer c, double balance, int cid)
	      {
	       
	       
	         Session session = sessionFactory.openSession();
	          session.beginTransaction();
	         Query query=session.createQuery("from Customer where cid=:cid");
	         query.setParameter("cid", cid);
	         double amount=c.getBalance();  
	         double bal=0;
	         System.out.println("form balance"+amount);
	         List<Customer> list=query.getResultList();
	         for(Customer cs:list) {
	        	 bal=cs.getBalance()+balance;
	        	 Query q=session.createQuery("update Customer set balance=:bal where cid=:cid");
	        	 q.setParameter("cid", cid);
	        	 q.setParameter("bal", bal);
	        	 q.executeUpdate();
	        	 
	         }
	         session.getTransaction().commit();
	         
	       
	        return true;
	      }
	    public List<Customer> showwallet(int cid)
	      {
	          Session session=sessionFactory.openSession();
	        Query query=session.createQuery("from Customer where cid=:cid");
	         query.setParameter("cid",cid);
	              List<Customer> list=query.getResultList();
	              System.out.println(list);
	              return list;
	          
	      }
	     

	
}
	
	
	

