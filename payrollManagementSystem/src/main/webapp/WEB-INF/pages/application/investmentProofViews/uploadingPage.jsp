<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="taglib" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Investment Proofs Uploading</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/style.css"/>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/respontiveButton.js"></script>

<script>
function proof1Fun()
{
	var filePath = document.getElementById("proof1").value;
	if(!filePath.endsWith(".pdf"))
		{
			alert("Please upload the file in pdf format only.");
			document.getElementById("proof1").value="";
		}
	}
function proof2Fun()
{
	var filePath = document.getElementById("proof2").value;
	if(!filePath.endsWith(".pdf"))
		{
			alert("Please upload the file in pdf format only.");
			document.getElementById("proof2").value="";
		}
	}
function proof3Fun()
{
	var filePath = document.getElementById("proof3").value;
	if(!filePath.endsWith(".pdf"))
		{
			alert("Please upload the file in pdf format only.");
			document.getElementById("proof3").value="";
		}
	}
function proof4Fun()
{
	var filePath = document.getElementById("proof4").value;
	if(!filePath.endsWith(".pdf"))
		{
			alert("Please upload the file in pdf format only.");
			document.getElementById("proof4").value="";
		}
	}
function proof5Fun()
{
	var filePath = document.getElementById("proof5").value;
	if(!filePath.endsWith(".pdf"))
		{
			alert("Please upload the file in pdf format only.");
			document.getElementById("proof5").value="";
		}
	}
</script>
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
		<taglib:form modelAttribute="investmentProofs"
			encType="multipart/form-data" action="uploadSuccess">
			<table>
				<tr>
					<td><taglib:hidden path="employeeid" /></td>
				</tr>
				<tr>
					<td><taglib:label path="financialYear">Financial Year</taglib:label></td>
					<td><taglib:select path="financialYear"
							items="${financialYears}" /></td>
				</tr>
			</table>
			<br>
			<table>
				<tr>
					<th>Declarations</th>
					<th>Amount</th>
					<th>Document Proof</th>
				</tr>
				<tr>
					<td>House Rent Allowance</td>
					<td><taglib:input path="houseRentAllowanceAmount"
							type="number" /> <taglib:errors path="houseRentAllowanceAmount" />
					</td>

					<td><taglib:input path="houseRentAllowanceFile" type="file"
							accept=".pdf" id="proof1" oninput="proof1Fun()" /> <taglib:errors
							path="houseRentAllowanceFile" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Children Tution Fee</td>
					<td><taglib:input path="childernTutionFeeAmount" type="number" />
						<taglib:errors path="childernTutionFeeAmount" /></td>

					<td><taglib:input path="childernTutionFeeFile" type="file"
							accept=".pdf" id="proof2" oninput="proof2Fun()" /> <taglib:errors
							path="childernTutionFeeFile" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Education Loan Interest</td>
					<td><taglib:input path="educationLoanInterestAmount"
							type="number" /> <taglib:errors
							path="educationLoanInterestAmount" /></td>

					<td><taglib:input path="educationLoanInterestFile" type="file"
							accept=".pdf" id="proof3" oninput="proof3Fun()" /> <taglib:errors
							path="educationLoanInterestFile" /></td>

					<td><pre>    ${UploadErrorMsg}</pre></td>
				</tr>
				<tr>
					<td>Medical Insurance</td>
					<td><taglib:input path="medicalInsuranceAmount" type="number" />
						<taglib:errors path="medicalInsuranceAmount" /></td>

					<td><taglib:input path="medicalInsuranceFile" type="file"
							accept=".pdf" id="proof4" oninput="proof4Fun()" /> <taglib:errors
							path="medicalInsuranceFile" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Mutual Funds</td>
					<td><taglib:input path="mutualFundsAmount" type="number" /> <taglib:errors
							path="mutualFundsAmount" /></td>

					<td><taglib:input path="mutualFundsFile" type="file"
							accept=".pdf" id="proof5" oninput="proof5Fun()" /> <taglib:errors
							path="mutualFundsFile" /></td>
					<td></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</taglib:form>
	</div>
</body>
</html>