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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/tablestyle.css">

<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/respontiveButton.js"></script>
</head>
<title>View Accountants list</title>
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
	<div style="padding: 3%;">
		<h2>View Accountants list</h2>
		<div>
			<table>
				<tr>
					<th>Employee ID</th>
					<th>Name</th>
					<th>Date of Birth</th>
					<th>Gender</th>
					<th>Phone number</th>
					<th>Email ID</th>
					<th>Date of Joining</th>
					<th>Designation</th>
					<th>Department</th>
					<th>Options</th>
				</tr>
				<c:forEach var="employee" items="${employeeList}">
					<tr>
						<td>${employee.employeeId}</td>
						<td>${employee.employeeName}</td>
						<td>${employee.dateOfBirth}</td>
						<td>${employee.gender}</td>
						<td>${employee.phoneNum}</td>
						<td>${employee.emailId}</td>
						<td>${employee.dateOfJoining}</td>
						<td>${employee.designation}</td>
						<td>${employee.department}</td>
						<td><a href="viewAllAccountants/edit/${employee.employeeId}">Edit</a>
							<a href="viewAllAccountants/delete/${employee.employeeId}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>