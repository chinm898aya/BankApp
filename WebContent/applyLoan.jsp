<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Applying Page</title>
</head>
<body>
	<form action="appliedLoan.jsp">
		<input type="radio" name="loan" required value="Home Loan" />Home Loan<br>
		<input type="radio" name="loan" required value="Education Loan" />Education
		Loan<br> <input type="radio" name="loan" required
			value="Car Loan" />Car Loan<br> <input type="radio" name="loan"
			required value="Gold Loan" />Gold Loan<br> <input type="radio"
			name="loan" required value="Personal Loan" />Personal Loan<br> <input
			type="radio" name="loan" required value="iphone Loan" />iphone Loan<br>
		<br> <input type="submit" value="apply" />
	</form>
</body>
</html>