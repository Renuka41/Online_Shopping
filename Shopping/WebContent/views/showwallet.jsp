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
<body bgcolor="pink">
<c:forEach  var="s" items="${list}">
<h2>Balance</h2>
<table>
<tr>
<td>
<h4><c:out value="${s.getBalance()}"></c:out></h4>
</td>

</tr>
</table>
</c:forEach>
</body>
</center>
</html>         