<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="taglib" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<c:if test="${employee.usertype eq 'Employee' }">
		<jsp:include page="../../templates/headerEmployee.jsp"></jsp:include>
	</c:if>
		<c:if test="${employee.usertype eq 'Accountant' }">
		<jsp:include page="../../templates/headerAccountant.jsp"></jsp:include>
	</c:if>
	
		<c:if test="${employee.usertype eq 'Administrator' }">
		<jsp:include page="../../templates/headerAdmin.jsp"></jsp:include>
	</c:if><br><br>
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
			<taglib:form action="generationCompletionPage">
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
