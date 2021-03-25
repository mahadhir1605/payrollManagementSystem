<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="taglib" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/style.css"/>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/respontiveButton.js"></script>

<title>Enter details</title>
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
		<p>${ExceptionMsg}</p>
		<taglib:form modelAttribute="verificationDetailsEntity"
			action="detailsToBeVerified">
			<table>
				<tr>
					<td><taglib:label path="employeeId">Employee Id</taglib:label></td>
					<td><taglib:input path="employeeId" type="number" /> <taglib:errors
							path="employeeId" /></td>
				</tr>
				<tr>
					<td><taglib:label path="financialYear">Financial Year</taglib:label></td>
					<td><taglib:select path="financialYear"
							items="${financialYears}"></taglib:select></td>
				</tr>
				<tr><td></td>
					<td><br><input type="submit" value="Get Investment Proofs Details"></td>
				</tr>
			</table>


		</taglib:form>
	</div>
</body>
</html>