<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Completion Page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/style.css">
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
<br><br>

	<h3>${completionMsg}</h3>
	<br>
	<a href="home">Home</a>
</body>
</html>