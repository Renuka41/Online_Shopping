<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<style>  
	table,tr,td
	{
border:1px solid black;
width:30%;
text-align:center;
}
</style>
</head>
<center>
<h2>Product List</h2>
<body bgcolor="pink">
<table border="7">

<tr>
<td>Product id</td>
<td>name</td>
<td>Price</td>
<td>quantity</td>
<td>Discount</td>
</tr>
<c:forEach  var="s" items="${list}">

<tr>
<td>${s.getId()}</td>
<td>${s.getName()}</td>
<td>${s.getPrice()}</td>
<td>${s.getQuantity()}</td>
<td>${s.getDiscount()}</td>
</tr>
</c:forEach>
</table>
</body>
</center>
</html>         