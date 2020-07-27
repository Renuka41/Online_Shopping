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
<h2>Customer List</h2>
<body bgcolor="pink">
<table border="7">

<tr>
<td>Customer id</td>
<td>name</td>
<td>Password</td>
<td>Balance</td>
</tr>
<c:forEach  var="s" items="${lis}">
<tr>
<td>${s.getCid()}</td>
<td>${s.getName()}</td>
<td>${s.getPass()}</td>
<td>${s.getBalance()}</td>
</tr>
</c:forEach>
</table>
</body>
</center>
</html>         