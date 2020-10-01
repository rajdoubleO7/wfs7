<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "demo" uri="http://amit.com" %>
<%@taglib prefix = "newdemo" uri="http://xyz.com" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Date is <%= new java.util.Date() %></h3>
	<demo:mytag query ="select * from customer" database="hsbcdb" username="admin" password="derby">
	</demo:mytag>
</body>
</html>