<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Leave History</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/style.css">
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/respontiveButton.js"></script>

<style>
table,th,tr,td 
{
	border: 1px solid black;
	border-collapse: collapse;
}
.dClass
{
	padding:10px;
}
</style>

</head>
<body>
	<div>
		<h2 style="text-align: center;">Employee Portal</h2>
	</div>
	<div style="padding-right: 3%;">
		<p align="right" >Logged in as ${employee.employeeName }</p>
		<p align="right">
			<a href="logout">Logout</a>
	</div>

	<div class="topnav" id="myTopnav">
		<a href="home" class="active">Home</a>
		<a href="viewPayslip">View my Payslip</a>
		<a href="leaveFormPage">Apply for leave</a>
			<a href="viewLeaveHistory">View Leave History</a>
		
		<a href="updateSelfDetails">Update my details</a>
		<a href="submitInvestmentProofs">Investment Proofs</a>
		<a href="javascript:void(0);" class="icon" onclick="myFunction()">
		<i class="fa fa-bars"></i></a>
	</div>

	<div style="padding-left: 2%; padding-right: 2%;">
		<h3>Your Leave History</h3>
		<table>
			<tr>
				<th>Employee ID</th>
				<th>Leave Type</th>
				<th class="dClass">Start Date</th>
				<th class="dClass">End Date</th>
				<th>Total Days</th>
				<th>Reason</th>
			</tr>
			<core:forEach var="LD" items="${listOfLeaveData}">
				<tr>
					<td>${LD.employeeId}</td>
					<td>${LD.leaveType}</td>
					<td class="dClass">${LD.startDate}</td>
					<td class="dClass">${LD.endDate}</td>
					<td>${LD.totalDays}</td>
					<td>${LD.reason}</td>
				</tr>
			</core:forEach>
		</table>
	</div>
</body>
</html>