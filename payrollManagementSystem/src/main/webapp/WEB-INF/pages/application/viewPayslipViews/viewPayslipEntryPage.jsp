<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<c:if test="${employee.usertype eq 'Employee' }">
		<jsp:include page="../../templates/headerEmployee.jsp"></jsp:include>
	</c:if>
		<c:if test="${employee.usertype eq 'Accountant' }">
		<jsp:include page="../../templates/headerAccountant.jsp"></jsp:include>
	</c:if>
	
		<c:if test="${employee.usertype eq 'Administrator' }">
		<jsp:include page="../../templates/headerAdmin.jsp"></jsp:include>
	</c:if>
	
	<div style="padding-left: 3%; padding-top: 3%; ">
	<h2>View payslip</h2>
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