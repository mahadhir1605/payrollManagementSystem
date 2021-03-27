<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leave Application Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/style.css">
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/respontiveButton.js"></script>

</head>
<body>
<script>
//Gobal variables
var startDate;
var endDate;
function SDfun()
{
	startDate = new Date(document.getElementById("startDate").value);
	
	if(startDate!=null && endDate!=null)
	{
		if((endDate-startDate)<0)
			{
			document.getElementById("totalDaysIP").value = 0;
			var totalDaysElem = document.getElementById("totalDays")
			totalDaysElem.setAttribute("value",0);
			}
		else
			{
			document.getElementById("totalDaysIP").value = (endDate-startDate)/(1000 * 60 * 60 * 24);
			
			var totalDaysElem = document.getElementById("totalDays");

			totalDaysElem.setAttribute("value",(endDate-startDate)/(1000 * 60 * 60 * 24));
			}
	}
	}
function EDfun()
{
	endDate = new Date(document.getElementById("endDate").value);
	
	
	if(startDate!=null && endDate!=null)
		{
			if((endDate-startDate)<0)
			{
				document.getElementById("totalDaysIP").value = 0;
				var totalDaysElem = document.getElementById("totalDays")
				totalDaysElem.setAttribute("value",0);
			}
			else
			{
				document.getElementById("totalDaysIP").value = (endDate-startDate)/(1000 * 60 * 60 * 24);
		
				var totalDaysElem = document.getElementById("totalDays")
				totalDaysElem.setAttribute("value",(endDate-startDate)/(1000 * 60 * 60 * 24));
		}
		}
	
	
	
	}

</script>
	<c:if test="${employee.usertype eq 'Employee' }">
		<jsp:include page="../../templates/headerEmployee.jsp"></jsp:include>
	</c:if>
		<c:if test="${employee.usertype eq 'Accountant' }">
		<jsp:include page="../../templates/headerAccountant.jsp"></jsp:include>
	</c:if>
	
		<c:if test="${employee.usertype eq 'Administrator' }">
		<jsp:include page="../../templates/headerAdmin.jsp"></jsp:include>
	</c:if>
	<div style="padding: 3%">
		<h2>Leave Application</h2>
		<form:form modelAttribute="leaveData" action="leaveResultPage"
			method="post">

			<table>
				<tr>
					<td><form:label path="employeeId">Employee Id</form:label></td>
					<td><form:input path="employeeId" readonly="true" /></td>
				</tr>

				<tr>
					<td><form:label path="leaveType">Leave Type</form:label></td>
					<td><form:select path="leaveType" items="${leaveTypes}"></form:select></td>
				</tr>

				<tr>
					<td><form:label path="startDate">Start Date</form:label></td>
					<td><form:input type="date" path="startDate" id="startDate"
							oninput="SDfun()" placeholder="yyyy-mm-dd" /> <form:errors
							path="startDate" /></td>
				</tr>

				<tr>
					<td><form:label path="endDate">End Date</form:label></td>
					<td><form:input type="date" path="endDate" id="endDate"
							oninput="EDfun()" placeholder="yyyy-mm-dd" /> <form:errors
							path="endDate" /></td>
				</tr>

				<tr>
					<td><form:label path="totalDays">Total Days</form:label></td>
					<td><form:hidden path="totalDays" id="totalDays" /> <input
						type="text" id="totalDaysIP" value="${leaveData.totalDays}"
						disabled> <form:errors path="totalDays" /></td>
					<td>${errorMsg}</td>
				</tr>

				<tr>
					<td><form:label path="reason">Reason</form:label></td>
					<td><form:textarea path="reason" /> <form:errors
							path="reason" /></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>

			</table>
		</form:form>
		${message }
	</div>
</body>
</html>