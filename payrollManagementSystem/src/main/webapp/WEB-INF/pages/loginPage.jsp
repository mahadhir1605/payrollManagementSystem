<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
</head>
<body style="font-family: Arial, Helvetica, sans-serif;">
	<div>
		<h2 style="text-align: center;">Employee Portal</h2>
	</div>
	<h3 style="text-align: center;">User login</h3>
	<div align="center">
		<form:form modelAttribute="login" action="login">

			<table>
				<tr>
					<td><form:label path="employeeId">Employee ID :</form:label></td>
					<td><form:input type="number" pattern="[0-9]{7}" title="Must be 7 digits"
							path="employeeId"	></form:input></td>
					<td><form:errors path="employeeId"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="password">Password :</form:label></td>
					<td><form:password path="password"></form:password></td>
					<td><form:errors path="password"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="userType">User Type :</form:label></td>
					<td><form:select path="userType" items="${userType}" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>

	<div align="center">
		<br /> <a href="forgotPassword">Forgot Password?</a>
	</div>
</body>
</html>