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
<table>
<tr><td>Cid</td>
<td>id</td> 
<td>Quanty</td></tr>
<c:forEach  var="s" items="${li}">
<form action="paybill">
    <tr>
    
    <td>
        <input type="hidden" name="cid" value="${s.getCid()}">${s.getCid()}
    </td>
    <td>
        <input type="hidden" name="id" value="${s.getId()}">${s.getId()}
    </td>
    <td>
        <input type="hidden" name="quantity" value="${s.getQuantity()}">${s.getQuantity()}
    </td>
    <td><input type="submit" value="PayBill"></td>    
    </tr>
</form>
</c:forEach>
</table>

 

</body>
</center>
</html>