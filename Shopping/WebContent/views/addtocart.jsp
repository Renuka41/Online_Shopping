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
<h2>add to cart products</h2>
<br><form action="addtocart">
Enter the id<input type="text" name="id"><br>
Enter the quantity<input type="text" name="quantity"><br>
<input type="submit" name="btn" value="add cart">
</form>
                                  


</body>
</center>
</html>         