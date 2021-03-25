<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="taglib" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Confirmation Page</title>
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
<h3 style="text-align:center;">PaySlip for the month ${paySlip.month} ${paySlip.year}</h3>
<div>
<table style="width:100%;" class="lightBorderClass">
	<tr class="lightBorderClass">
		<td class="lightBorderClass"><b>Employee Id</b></td>
		<td class="lightBorderClass">${paySlip.employeeId}</td>
		<td class="lightBorderClass"><b>Employee Name</b></td>
		<td class="lightBorderClass">${paySlip.employeeName}</td>
	</tr>
	<tr class="lightBorderClass">
		<td class="lightBorderClass"><b>Department</b></td>
		<td class="lightBorderClass">${paySlip.department}</td>
		<td class="lightBorderClass"><b>Designation</b></td>
		<td class="lightBorderClass">${paySlip.designation}</td>
	</tr>
	<tr class="lightBorderClass">
		<td class="lightBorderClass"><b>Date of Birth</b></td>
		<td class="lightBorderClass">${paySlip.dateOfBirth}</td>
		<td class="lightBorderClass"><b>Date of Joining</b></td>
		<td class="lightBorderClass">${paySlip.dateOfJoining}</td>
	</tr>
	<tr class="lightBorderClass">
		<td class="lightBorderClass"><b>Gender</b></td>
		<td class="lightBorderClass">${paySlip.gender}</td>
		<td class="lightBorderClass"><b>Bank A/c No.</b></td>
		<td class="lightBorderClass">${paySlip.bankAccNum }</td>
	</tr>
	<tr class="lightBorderClass">
		<td class="lightBorderClass"><b>Phone No.</b></td>
		<td class="lightBorderClass">${paySlip.phoneNum}</td>
		<td class="lightBorderClass"><b>Email Id</b></td>
		<td class="lightBorderClass">${paySlip.emailId}</td>
	</tr>
</table>
</div>
<div>
<br>
<br>

</div>

<div>
	<table style="width:100%;" class="darkBorderClass">
		<tr>
			<td class="darkBorderClass"><b>Earnings</b></td>
			<th class="darkBorderClass"><b>Amount</b></th>
			<td class="darkBorderClass"><b>Deductions</b></td>
			<th class="darkBorderClass"><b>Amount</b></th>
		</tr>
		<tr>
			<td class="lightBorderClass">Basic</td>
			<td class="lightBorderClass" style="text-align:center;">${paySlip.basicSalary}</td>
			<td class="lightBorderClass">Provident Fund</td>
			<td class="lightBorderClass" style="text-align:center;">${paySlip.providentFund}</td>
		</tr>
		<tr>
			<td class="lightBorderClass">Special Allowance</td>
			<td class="lightBorderClass" style="text-align:center;">${paySlip.specialAllowance}</td>
			<td class="lightBorderClass">Professional Tax</td>
			<td class="lightBorderClass" style="text-align:center;">${paySlip.professionalTax}</td>
		</tr>
		<tr>
			<td class="lightBorderClass">House Rent Allowance</td>
			<td class="lightBorderClass" style="text-align:center;">${paySlip.HRA}</td>
			<td class="lightBorderClass">Loss of Pay</td>
			<td class="lightBorderClass" style="text-align:center;">${paySlip.deductionsDueToLOP}</td>
		</tr>
		<tr>
			<td class="lightBorderClass">Leave Travel Allowance</td>
			<td class="lightBorderClass" style="text-align:center;">${paySlip.LTA}</td>
			<td class="lightBorderClass"></td>
			<td class="lightBorderClass"></td>
		</tr>
		<tr>
			<td class="lightBorderClass">Food Coupon</td>
			<td class="lightBorderClass" style="text-align:center;">${paySlip.foodCoupon}</td>
			<td class="lightBorderClass"></td>
			<td class="lightBorderClass"></td>
		</tr>
		<tr>
			<td class="darkBorderClass"><b>Total Earnings</b></td>
			<td class="darkBorderClass" style="text-align:center;">${paySlip.totalEarnings}</td>
			<td class="darkBorderClass"><b>Total Deductions</b></td>
			<td class="darkBorderClass" style="text-align:center;">${paySlip.totalDeductions}</td>
		</tr>
	</table>
</div>
<br>
<div class="darkBorderClass" style="width:100%;">
	<pre><b style="font-size:20px;">   Net Pay:  Rs.${paySlip.netPay} </b></pre>
</div>
<br>
<div>
	<table style="width:100%;" class="lightBorderClass">
		<tr class="lightBorderClass">
			<td class="lightBorderClass"><b>Days In Month</b></td>
			<td class="lightBorderClass"><b>LOP Days</b></td>
			<td class="lightBorderClass"><b>Net Days Worked</b></td>
		</tr>
		<tr class="lightBorderClass">
			<td class="lightBorderClass">${paySlip.numOfDaysInGivenMonth}</td>
			<td class="lightBorderClass">${paySlip.LOPDays}</td>
			<td class="lightBorderClass">${paySlip.netDaysWorked }</td>
		</tr>
	</table>
</div>
<table style="width:85%;">
	<tr>
		<td style="text-align:right">
			<taglib:form modelAttribute="paySlip" action="generationCompletionPage">
				<taglib:hidden path="employeeId" value="${paySlip.employeeId}"/>
				<taglib:hidden path="employeeName" value="${paySlip.employeeName}"/>
				<taglib:hidden path="department" value="${paySlip.department}"/>
				<taglib:hidden path="designation" value="${paySlip.designation}"/>
				<taglib:hidden path="dateOfBirth" value="${paySlip.dateOfBirth}"/>
				<taglib:hidden path="dateOfJoining" value="${paySlip.dateOfJoining}"/>
				<taglib:hidden path="gender" value="${paySlip.gender}"/>
				<taglib:hidden path="bankAccNum" value="${paySlip.bankAccNum}"/>
				<taglib:hidden path="phoneNum" value="${paySlip.phoneNum}"/>
				<taglib:hidden path="emailId" value="${paySlip.emailId}"/>
		
				<taglib:hidden path="basicSalary" value="${paySlip.basicSalary}"/>
				<taglib:hidden path="specialAllowance" value="${paySlip.specialAllowance}"/>
				<taglib:hidden path="HRA" value="${paySlip.HRA}"/>
				<taglib:hidden path="LTA" value="${paySlip.LTA}"/>
				<taglib:hidden path="foodCoupon" value="${paySlip.foodCoupon}"/>
				<taglib:hidden path="providentFund" value="${paySlip.providentFund}"/>
				<taglib:hidden path="professionalTax" value="${paySlip.professionalTax}"/>
				<taglib:hidden path="deductionsDueToLOP" value="${paySlip.deductionsDueToLOP}"/>
				<taglib:hidden path="totalEarnings" value="${paySlip.totalEarnings}"/>
				<taglib:hidden path="totalDeductions" value="${paySlip.totalDeductions}"/>
				<taglib:hidden path="netPay" value="${paySlip.netPay}"/>
		
				<taglib:hidden path="month" value="${paySlip.month}"/>
				<taglib:hidden path="year" value="${paySlip.year}"/>
				<taglib:hidden path="numOfDaysInGivenMonth" value="${paySlip.numOfDaysInGivenMonth}"/>
				<taglib:hidden path="LOPDays" value="${paySlip.LOPDays}"/>
				<taglib:hidden path="netDaysWorked" value="${paySlip.netDaysWorked}"/>
		
				<input type="submit" value="Confirm">
			</taglib:form>
		</td>
		<td>
			<form action="getDetails">
				<input type="submit" value="Back">
			</form>
		</td>
	</tr>
</table>


</body>
</html>