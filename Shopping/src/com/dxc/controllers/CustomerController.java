package com.dxc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.Cart;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;
import com.dxc.service.CustomerService;
@Controller
@RequestMapping("/views")
public class CustomerController {
	boolean b;
	String message;
	List<Cart> li=new ArrayList<>();
		Customer c=new Customer();
		CustomerService service=new CustomerService();
		
		@RequestMapping("/custo")

	public String customerlogin(@ModelAttribute Customer cs,HttpSession session) {
	int cid=cs.getCid();
    session.setAttribute("cid", cid);
	boolean b=service.customerlogin(cs);
	System.out.println(cs.getPass());
	if(cs.getPass().equals("acustomer"))
	{
		return "changepassword";
	}
	
	else if(b==true) 
	{
		
		 return"operations";		
		 }
	else 
	{
		String message="login unsucessful";
	 session.setAttribute("message", message);
	 return"message";
	}
}
		
	@RequestMapping("/change")
	public String passwordchange(@RequestParam String pass,@RequestParam String pass1,HttpSession session)
	
    {	
		int cid=(int)session.getAttribute("cid");
		System.out.println(cid);

        System.out.println(pass);
        System.out.println(pass1);
        System.out.println(pass.equals(pass1));
        if(pass.equals(pass1))
        {
        	 boolean b=service.passwordChange(cid,pass);
        
            session.setAttribute("message", b);
            return "logincustomer";
        }
        else if(b==false)
        {
            String message="password incorrect";
            session.setAttribute("message", message);
            return "message";
            
        }
        else
        {
             String message="reenter password incorrect";
            session.setAttribute("message", message);
return "message";
        }      
    }
	
	@RequestMapping("/products")
	public String availableProducts(Model m)
	{
		List<Product> list=service.availableProducts();
		m.addAttribute("list", list);
		return "showproducts";
	}
	
	@RequestMapping("/addtocart")
	public String addproducttocart(@RequestParam int id, @ModelAttribute Cart c,@ModelAttribute Product p,HttpSession session,Model m)
	{
		   int cid = (int) session.getAttribute("cid");
		boolean b=service.addproducttocart(id,c, cid, p);
		if(b)
		{
		message="Sussessfully added to cart";
		m.addAttribute("message", message);
		return "message";
		}
		else
		{
			message="product is not found can't able to add to cart";
			m.addAttribute("message", message);
			return "message";
		}
}
	
	@RequestMapping("/cart")
	public String showCartProducts(Model m,HttpSession session)
	{
		int cid = (int) session.getAttribute("cid");
		List<Cart> li=service.showCartProducts(cid);
		
		if(!(li.isEmpty()))
		{
			m.addAttribute("li", li);
			return "cartlist";
		}
		else
		{
			message="cart is empty";
			m.addAttribute("message", message);
			return "message";
		}
		
	}
	@RequestMapping("/addbalancetowallet")
    public String walletBlance(@RequestParam int balance,HttpSession session,@ModelAttribute Customer c,Model m)
    {        int cid = (int) session.getAttribute("cid");
    
        c.setCid(cid);
        c.setBalance(balance);
      boolean b= service.walletBalance(c,balance,cid);
        if(b)
        {
        message="Balance is addedd successfully to the wallet";
        m.addAttribute("message", message);
        return "message";
    }
        return message;
    } 
	@RequestMapping("/paybill")
    public String getProductByCart(@ModelAttribute Cart c,Model m)
    {
       Product p=service.getProduct(c.getId());
       p.setQuantity(c.getQuantity());
       m.addAttribute("p",p);
       return "paybill";
    }


	
	@RequestMapping("/pay")
    public String pay(@RequestParam int id,@RequestParam double payableamount,Model m,HttpSession session)
    {System.out.println("gong to pay");
        int cid=(int)session.getAttribute("cid");
        boolean b=service.pay(cid,id,payableamount);
        if(b==true) {
            message="Payyed Successfully";
            m.addAttribute("message", message);
            
            return "message";
            
        }
        else
        {
            message="insufficient balance";
            m.addAttribute("message", message);
            return "message";
            
        }
        
    }
	@RequestMapping("/showwallet")
	public String showwallet(Model m,HttpSession session)
	{
		int cid = (int) session.getAttribute("cid");
		List<Customer> list=service.showwallet(cid);
		
		if(!(list.isEmpty()))
		{
			m.addAttribute("list", list);
			return "showwallet";
		}
		else
		{
			message="........!!!";
			m.addAttribute("message", message);
			return "message";
		}
		
	}
    
    
    
    
    
    
}
	
	
	
	



