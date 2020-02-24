<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Fund Transfer</title>
</head>
<body>
	<form action="Transfer">
		<table>
			<tr>
				<td>Receiver account number:</td>
				<td><input type="text" name="raccno"
					placeholder="enter receiver account number" /></td>
			</tr>
			<tr>
				<td>Amount:</td>
				<td><input type="text" name="amnt"
					placeholder="enter a valid amount" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="send" /></td>
			</tr>


		</table>


	</form>
</body>
</html>