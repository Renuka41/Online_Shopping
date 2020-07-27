<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<center>
<body bgcolor="pink">
<table >
<form action="pay">

     <b>Name </b>  :<input type="hidden" name="name" value="${p.getName()}">${p.getName()}
    <br><br>
  
      <b> Product Id:</b>  <input type="hidden" name="id" value="${p.getId()}">${p.getId()}
   <br><br>
    
       <b> Quantity:</b> <input type="hidden" name="quantity" value="${p.getQuantity()}">${p.getQuantity()}
    <br><br>
    <b> price: </b> <input type="hidden" name="price" value="${p.getPrice()}">${p.getPrice()}
 <br><br>
 <b> Discount:</b>
    
        <input type="hidden" name="discount" value="${p.getDiscount()}">${p.getDiscount()}<br><br>
       <b> Amount: </b>
    <c:set var="totalprice" value="${p.getQuantity()*p.getPrice()}"></c:set>
    <c:set var="discount" value="${ p.getDiscount()/100}"></c:set>
    <c:set var="discountAmmount" value="${totalprice*discount}"></c:set>
    <c:set var="payableAmmount" value="${totalprice-discountAmmount}"></c:set>
    
       <input type="hidden" name="payableamount" value="${payableAmmount}">${payableAmmount}<br>
    <input type="submit" value="Pay">
    
</form>
</body>
</center>
</html>