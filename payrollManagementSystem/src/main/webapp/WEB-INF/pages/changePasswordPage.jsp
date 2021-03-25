<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Change Password</title>
</head>
<body style="font-family: Arial, Helvetica, sans-serif;">
	<div>
		<h2 style="text-align: center;">Employee Portal</h2>
	</div>
	<h3 style="text-align: center;">Change password</h3>
	<div align="center">
		<form:form modelAttribute="employee" method="POST"
			action="changePassword">
			<table>
				<tr>
					<td><form:label path="employeeId">Employee ID : </form:label></td>
					<td><form:input path="employeeId" readonly="true" /></td>

				</tr>
				<tr>
					<td><form:label path="employeeName">Employee Name : </form:label></td>
					<td><form:input path="employeeName" readonly="true" /></td>
				</tr>
				<tr>
					<td><form:label path="password">New Password :</form:label></td>
					<td><form:password path="password" pattern="^(?=.*\d).{8,12}$" /></td>
					<td><form:errors path="password"></form:errors>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Change Password" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>