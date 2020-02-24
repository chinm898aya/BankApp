<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Welcome Page</title>
</head>
<body>
	<%
		out.println("Welcome to Swiss Bank");
	%>
	<br>
	<br>
	<form action="CheckBalance">
		<button type="submit">Check Balance</button>
	</form>
	<form action="changePwd.jsp">
		<button type="submit">Change Password</button>
	</form>
	<form action="transfer.jsp">
		<button type="submit">Transfer fund</button>
	</form>
	<form action="applyLoan.jsp">
		<button type="submit">Apply For Loan</button>
	</form>
	<form action="GetStatement">
		<button type="submit">get statement</button>
	</form>
	<form action="Logout">
		<button type="submit">Logout</button>
	</form>
</body>
</html>