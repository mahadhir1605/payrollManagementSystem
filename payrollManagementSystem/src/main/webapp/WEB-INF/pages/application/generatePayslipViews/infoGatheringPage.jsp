<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="taglib" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter details</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/style.css">
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


<div style="padding: 3%;">
<h2>Please enter the details to generate the PaySlip.</h2>

<taglib:form modelAttribute="dataTransferEntity" action="confirmationPage" method="post">
<table>
	<tr>
	<td>
		<taglib:label path="employeeId">Employee Id</taglib:label></td><td>
		<taglib:input path="employeeId" type="number"/></td><td>
		<taglib:errors path="employeeId"/></td><td>
		${EmployeeErrorMsg}
	</td>
	</tr>
	<tr>
	<td>
		<taglib:label path="month">Month</taglib:label></td><td>
		<taglib:select path="month" items="${months}"></taglib:select></td><td>
	</td>
	</tr>
	<tr>
	<td>
		<taglib:label path="year">Year</taglib:label></td><td>
		<taglib:input path="year" type="number" id="yearId" oninput="yearFun()"/></td><td>
		<taglib:errors path="year"/></td><td>
		${DuplicateRecordErrorMsg}
		${AttendanceErrorMsg}
	</td><td></td>
	<td id="yearValidationMsg">
		
	</td>
	</tr>
	<tr>
	<td>
		<input type="submit" value="Generate">
	</td>
	</tr>
</table>
</taglib:form>
</div>
</body>
</html>