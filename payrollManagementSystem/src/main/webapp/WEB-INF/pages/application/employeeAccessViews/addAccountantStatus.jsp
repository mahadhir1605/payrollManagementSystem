<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/respontiveButton.js"></script>
</head>
<title>Add Accountant</title>
</head>
<body>
	<c:if test="${employee.usertype eq 'Employee' }">
		<jsp:include page="../../templates/headerEmployee.jsp"></jsp:include>
	</c:if>
	<c:if test="${employee.usertype eq 'Accountant' }">
		<jsp:include page="../../templates/headerAccountant.jsp"></jsp:include>
	</c:if>

	<c:if test="${employee.usertype eq 'Administrator' }">
		<jsp:include page="../../templates/headerAdmin.jsp"></jsp:include>
	</c:if>

	<h2>Accountant added successfully</h2>

	<table>
		<tr>
			<td>Employee Id :</td>
			<td>${e.employeeId}</td>
		</tr>
		<tr>
			<td>Name :</td>
			<td>${e.employeeName}</td>
		</tr>
		<tr>
			<td>Gender :</td>
			<td>${e.gender}</td>
		</tr>

		<tr>
			<td>Date of Birth :</td>
			<td>${e.dateOfBirth}</td>
		</tr>
		<tr>
			<td>Phone Number :</td>
			<td>${e.phoneNum}</td>
		</tr>

		<tr>
			<td>Email Id :</td>
			<td>${e.emailId}</td>
		</tr>

		<tr>
			<td>Date of Joining :</td>
			<td>${e.dateOfJoining}</td>
		</tr>

		<tr>
			<td>Designation :</td>
			<td>${e.designation}</td>
		</tr>

		<tr>
			<td>Department :</td>
			<td>${e.department}</td>
		</tr>

	</table>


</body>
</html>