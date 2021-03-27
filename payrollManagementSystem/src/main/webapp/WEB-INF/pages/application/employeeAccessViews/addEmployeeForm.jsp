<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/respontiveButton.js"></script>
</head>
<title>Add Employee</title>
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
	<div style="padding: 3%">
		<h2>Add Employee</h2>

		<form:form modelAttribute="newEmployee" action="addEmployee">
			<table>
				<tr>
					<td><form:label path="employeeName">Employee Name : </form:label></td>
					<td><form:input path="employeeName" />
				</tr>
				<tr>
					<td><form:label path="department">Department : </form:label></td>
					<td><form:input path="department" />
				</tr>
				<tr>
					<td><form:label path="designation">Designation : </form:label></td>
					<td><form:input path="designation" />
				</tr>
				<tr>
					<td><form:label path="dateOfBirth">Date of Birth : </form:label></td>
					<td><form:input path="dateOfBirth" type="date" />
				</tr>
				<tr>
					<td><form:label path="dateOfJoining">Date of Joining : </form:label></td>
					<td><form:input path="dateOfJoining" type="date" />
				</tr>
				<tr>
					<td><form:label path="gender">Gender : </form:label></td>
					<td><form:radiobuttons path="gender" items="${gender}" />
				</tr>
				<tr>
					<td><form:label path="bankAccNum">Bank Account Number : </form:label></td>
					<td><form:input path="bankAccNum" />
				</tr>
				<tr>
					<td><form:label path="phoneNum">Phone number : </form:label></td>
					<td><form:input path="phoneNum" />
				</tr>
				<tr>
					<td><form:label path="emailId">Email ID : </form:label></td>
					<td><form:input path="emailId" />
				</tr>
				<tr>
					<td><form:label path="password">Password : </form:label></td>
					<td><form:password path="password" />
				</tr>
				<tr>
					<td><form:hidden path="usertype" />
				</tr>

				<tr>
					<td><form:label path="employeeCtc.basicSalary"> Basic Pay : </form:label></td>
					<td><form:input path="employeeCtc.basicSalary" />
				</tr>
				<tr>
					<td><form:label path="employeeCtc.specialAllowance"> Special Allowance : </form:label></td>
					<td><form:input path="employeeCtc.specialAllowance" />
				</tr>
				<tr>
					<td><form:label path="employeeCtc.HRA"> House Rent Allowance : </form:label></td>
					<td><form:input path="employeeCtc.HRA" />
				</tr>
				<tr>
					<td><form:label path="employeeCtc.LTA"> Leave Travel Allowance : </form:label></td>
					<td><form:input path="employeeCtc.LTA" />
				</tr>
				<tr>
					<td><form:label path="employeeCtc.foodCoupon"> Food coupon : </form:label></td>
					<td><form:input path="employeeCtc.foodCoupon" />
				</tr>
				<tr>
					<td><form:label path="employeeCtc.PF"> Employee Provident Fund : </form:label></td>
					<td><form:input path="employeeCtc.PF" />
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>