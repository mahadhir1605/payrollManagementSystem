<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Forgot Password</title>
</head>
<body style="font-family: Arial, Helvetica, sans-serif;">
	<div>
		<h2 style="text-align: center;">Employee Portal</h2>
	</div>
	<h3 style="text-align: center;">Forgot password</h3>
	<div align="center">
		<form:form modelAttribute="Otp" method="post" action="otpAuth">
			<table>
				<tr>
					<td><form:hidden path="employeeId" /></td>
				</tr>
				<tr>
					<td><form:label path="otp">Enter OTP : </form:label></td>
					<td><form:input path="otp" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>