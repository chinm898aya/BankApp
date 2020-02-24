<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Change Password Page</title>
</head>
<body>
	<form action="ChangePwd">
		<table>
			<tr>
				<td>new password:</td>
				<td><input type="text" name="npwd"
					placeholder="enter new password" /></td>
			</tr>
			<tr>
				<td>confirm new password:</td>
				<td><input type="text" name="cnpwd"
					placeholder="enter same password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="change password" /></td>
			</tr>
		</table>
	</form>
</body>
</html>