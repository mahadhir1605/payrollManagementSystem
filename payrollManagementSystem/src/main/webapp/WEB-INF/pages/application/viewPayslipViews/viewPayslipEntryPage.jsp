<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View payslip</title>
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
		<p align="right">Logged in as ${employee.employeeName }</p>
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
	<div style="padding-left: 3%; padding-top: 3%; ">
	<h3>View payslip</h3>
		<form:form modelAttribute="dataTransferEntity" action="viewPayslip"
			method="post">
			<table>
				<tr>
				</tr>
				<tr>
					<td><form:label path="month">Month</form:label></td>
					<td><form:select path="month" items="${months}"></form:select></td>
				</tr>
				<tr>
					<td><form:label path="year">Year</form:label></td>
					<td><form:input path="year" pattern="(1|2)(\d{3})"
							title="Enter a valid year" id="yearId" oninput="yearFun()" /> <form:errors
							path="year" /> ${DuplicateRecordErrorMsg} ${AttendanceErrorMsg}
						${PayslipNotAvailableError }</td>
					<td id="yearValidationMsg"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="View Payslip"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>

<script type="text/javascript">
function yearFun()
{
	var yearValue = document.getElementById("yearId").value;
	if(yearValue<1000)
		{
			document.getElementById("yearValidationMsg").innerHTML = "Enter valid year.";
		}
	else
		{
			document.getElementById("yearValidationMsg").innerHTML = "";
		}
	}
</script>

</html>