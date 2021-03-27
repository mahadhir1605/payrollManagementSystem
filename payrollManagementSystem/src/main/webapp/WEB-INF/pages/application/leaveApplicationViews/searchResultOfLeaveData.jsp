<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Leave History</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/style.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/searchResultOfLeaveData.css">
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/respontiveButton.js"></script>

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
	<div style="padding-left: 2%; padding-right: 2%;">
		<h2>Your Leave History</h2>
		<table>
			<tr>
				<th>Employee ID</th>
				<th>Leave Type</th>
				<th class="dClass">Start Date</th>
				<th class="dClass">End Date</th>
				<th>Total Days</th>
				<th>Reason</th>
			</tr>
			<c:forEach var="LD" items="${listOfLeaveData}">
				<tr>
					<td>${LD.employeeId}</td>
					<td>${LD.leaveType}</td>
					<td class="dClass">${LD.startDate}</td>
					<td class="dClass">${LD.endDate}</td>
					<td>${LD.totalDays}</td>
					<td>${LD.reason}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>