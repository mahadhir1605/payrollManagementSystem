<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submitted Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/style.css">
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/respontiveButton.js"></script>
<style>
table,th,tr,td 
{
	border: 1px solid black;
	border-collapse: collapse;
	padding: 2%;
}

</style>
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
	<div style="padding-left: 3%; padding-right: 3%;">
		<h3>Leave application successful</h3>
		<table>
			<tr>
				<td>Employee Id</td>
				<td>${LD.employeeId}</td>
			</tr>
			<tr>
				<td>Leave Type:</td>
				<td>${LD.leaveType}</td>
			</tr>
			<tr>
				<td>start date:</td>
				<td>${LD.startDate}</td>
			</tr>
			<tr>
				<td>end date:</td>
				<td>${LD.endDate}</td>
			</tr>
			<tr>
				<td>Total Days:</td>
				<td>${LD.totalDays}</td>
			</tr>
			<tr>
				<td>Reason:</td>
				<td>${LD.reason}</td>
			</tr>
		</table>
	</div>
</body>
</html>