<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Forgot Password</title>
<script type="text/javascript">
	function validateInput() {
		var x = document.forms["forgotPasswordForm"]["employeeId"].value;
		if (x == "") {
			alert("Please fill in employee ID");
			return false;
		}
	}
</script>
</head>
<body style="font-family: Arial, Helvetica, sans-serif;">
	<div>
		<h2 style="text-align: center;">Employee Portal</h2>
	</div>
	<h3 style="text-align: center;">Forgot password</h3>
	<div align="center">
		<form:form modelAttribute="login" name="forgotPasswordForm"
			method="post" onsubmit="return validateInput()"
			action="forgotPassword">
			<table>
				<tr>
					<td><form:label path="employeeId">Employee ID :</form:label></td>
					<td><form:input pattern="[0-9]{7}" name="employeeId"
							path="employeeId" title="Must be of 7 digits" /></td>
				</tr>
				<tr></tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
		<a href="login">Back to login</a>
	</div>
</body>
</html>