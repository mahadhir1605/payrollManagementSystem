<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="taglib" uri="http://www.springframework.org/tags/form" %>

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
				<a href="uploadFiles">Investment Proofs</a> 
		     
	    <a href="getDetails">Generate payslip for Employees</a> 
	    <a href="generateReport">Generate organization report</a>    
	    <a href="addEmployee">Add an employee</a>                    
	    <a href="updateEmployeeDetails">Update Employee Profile</a>  
	    <a href="viewAllEmployees">View Employee list</a>            
	    <a href="verifyInvestmentProof">Investment proof Approval</a>
	    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
			<i class="fa fa-bars"></i>
		</a>
	</div>
<h3>Please enter the details to generate the PaySlip.</h3>

<taglib:form modelAttribute="dataTransferEntity" action="confirmationPage" method="post">
<table>
	<tr>
	<td>
		<taglib:label path="employeeId">Employee Id</taglib:label>
		<taglib:input path="employeeId" type="number"/>
		<taglib:errors path="employeeId"/>
		${EmployeeErrorMsg}
	</td>
	</tr>
	<tr>
	<td>
		<taglib:label path="month">Month</taglib:label>
		<taglib:select path="month" items="${months}"></taglib:select>
	</td>
	</tr>
	<tr>
	<td>
		<taglib:label path="year">Year</taglib:label>
		<taglib:input path="year" type="number" id="yearId" oninput="yearFun()"/>
		<taglib:errors path="year"/>
		${DuplicateRecordErrorMsg}
		${AttendanceErrorMsg}
	</td>
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

</body>
</html>