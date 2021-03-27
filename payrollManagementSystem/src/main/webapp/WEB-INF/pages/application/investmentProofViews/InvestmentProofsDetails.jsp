<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="taglib"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Investment Proofs Details</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/respontiveButton.js"></script>

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
	<div style="padding-left: 3%; padding-right: 3%">
		<h2>Investment proofs verification for Employee
			${investmentProofs.employeeId }</h2>

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