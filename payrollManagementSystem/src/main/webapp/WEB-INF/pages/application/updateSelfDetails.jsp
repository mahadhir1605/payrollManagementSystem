<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/style.css">
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/respontiveButton.js"></script>
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
	<br/><br/>
	<div style="padding-left: 3%;">
		<h3>Update your details</h3>

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