<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="taglib" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Investment Proofs Details</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/style.css"/>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/respontiveButton.js"></script>

</head>
<body>
	<div>
		<h2 style="text-align: center;">Employee Portal</h2>
	</div>
	<div style="padding-right: 3%;">
		<p align="right">Logged in as ${employee.employeeName }</p>
		<p align="right"><a href="logout">Logout</a>
	</div>

	<div class="topnav" id="myTopnav">
		<a href="home" class="active">Home</a>
		<a href="viewPayslip">View my Payslip</a>
		<a href="leaveFormPage">Apply for leave</a>
			<a href="viewLeaveHistory">View Leave History</a>
		
		<a href="updateSelfDetails">Update my details</a>
		<a href="uploadFiles">Investment Proofs</a>
		<a href="javascript:void(0);" class="icon" onclick="myFunction()">
		<i class="fa fa-bars"></i></a>
	</div>
	<div style="padding-left: 3%; padding-right: 3%">
		<h3>Investment Proofs Details of Employee with employeeId =
			${investmentProofs.employeeid}</h3>
		<table>
			<tr>
				<th>Declarations</th>
				<th>Amount</th>
				<th>Document Proof</th>
			</tr>
			<tr>
				<td>House Rent Allowance</td>
				<td>${investmentProofs.houseRentAllowanceAmount}</td>
				<td><a href="viewProof/${investmentProofs.employeeid}_proof1"
					target="_blank">View</a></td>
			</tr>
			<tr>
				<td>Children Tution Fee</td>
				<td>${investmentProofs.childernTutionFeeAmount}</td>
				<td><a href="viewProof/${investmentProofs.employeeid}_proof2"
					target="_blank">View</a></td>
			</tr>
			<tr>
				<td>Education Loan Interest</td>
				<td>${investmentProofs.educationLoanInterestAmount}</td>
				<td><a href="viewProof/${investmentProofs.employeeid}_proof3"
					target="_blank">View</a></td>
			</tr>
			<tr>
				<td>Medical Insurance</td>
				<td>${investmentProofs.medicalInsuranceAmount}</td>
				<td><a href="viewProof/${investmentProofs.employeeid}_proof4"
					target="_blank">View</a></td>
			</tr>
			<tr>
				<td>Mutual Funds</td>
				<td>${investmentProofs.mutualFundsAmount}</td>
				<td><a href="viewProof/${investmentProofs.employeeid}_proof5"
					target="_blank">View</a></td>
			</tr>
		</table>
		<br>
		<taglib:form modelAttribute="verificationDetailsEntity"
			action="investmentProofsStatus/APPROVED">
			<taglib:hidden path="employeeId"
				value="${investmentProofs.employeeid}" />
			<taglib:hidden path="financialYear"
				value="${investmentProofs.financialYear}" />
			<input type="submit" value="Approve">
		</taglib:form>
		<br>
		<taglib:form modelAttribute="verificationDetailsEntity"
			action="investmentProofsStatus/REJECTED">
			<taglib:hidden path="employeeId"
				value="${investmentProofs.employeeid}" />
			<taglib:hidden path="financialYear"
				value="${investmentProofs.financialYear}" />
			<input type="submit" value="Reject">
		</taglib:form>
	</div>
</body>
</html>