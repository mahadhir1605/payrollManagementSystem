<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/style.css">
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/respontiveButton.js"></script>
</head>
<body>
	<c:if test="${employee.usertype eq 'Employee' }">
		<jsp:include page="../templates/headerEmployee.jsp"></jsp:include>
	</c:if>
		<c:if test="${employee.usertype eq 'Accountant' }">
		<jsp:include page="../templates/headerAccountant.jsp"></jsp:include>
	</c:if>
	
		<c:if test="${employee.usertype eq 'Administrator' }">
		<jsp:include page="../templates/headerAdmin.jsp"></jsp:include>
	</c:if>
	<br/><br/>
	<div style="padding-left: 3%;">
		<h2>Update your details</h2>

		<!-- ${pageContext.request.contextPath}/ -->
		<form:form modelAttribute="employee" method="POST"
			action="updateSelfDetails">
			<table>
				<tr>
					<td><form:label path="employeeId">Employee ID : </form:label></td>
					<td><form:input path="employeeId" readonly="true" /></td>

				</tr>

				<tr>
					<td><form:label path="employeeName">Employee Name :</form:label></td>
					<td><form:input path="employeeName" readonly="true" /></td>
				</tr>
				<tr>
					<td><form:label path="emailId">Email ID : </form:label></td>
					<td><form:input path="emailId" cssErrorClass="error" /></td>
					<td><form:errors path="emailId"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="phoneNum">Phone number : </form:label></td>
					<td><form:input path="phoneNum" cssErrorClass="error" /></td>
					<td><form:errors path="phoneNum"></form:errors></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit edit" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>