<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Account Info</title>
</head>
<body>
	<%
		out.println("Hi " + session.getAttribute("name") + ", Your Current Balance Is Rs.  "
				+ session.getAttribute("balance"));
	%>
</body>
</html>