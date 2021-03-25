<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>

<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/style.css"/>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/script.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/yearFun.js"></script>
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
		<a href="updateSelfDetails">Update my details</a>                
	    <a href="generatePayroll">Generate payroll for Employees</a>     
	    <a href="addAccountantUser">Add Accountant</a>                   
	    <a href="viewAllEmployees">View or edit users list</a> <a></a>   
	</div>

	<div style="padding-left: 3%;">
		Welcome Administrator <br> Your employee ID is
		${employee.employeeId }
	</div>



</body>
</html>