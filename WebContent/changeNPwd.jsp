<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Set new Password</title>
</head>
<body>
	<form action="ChangeNPwd">
		<table>
			<tr>
				<td>new password:</td>
				<td><input type="text" name="np"
					placeholder="enter new password" /></td>
			</tr>
			<tr>
				<td>confirm new password:</td>
				<td><input type="text" name="cnp"
					placeholder="enter same password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>