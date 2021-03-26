	<div>
		<h2 style="text-align: center;">Employee Portal</h2>
	</div>
	<div style="padding-right: 3%;">
		<p align="right">Logged in as ${employee.employeeName }</p>
		<p align="right"><a href="<%= request.getContextPath() %>/logout">Logout</a>
	</div>

	<div class="topnav" id="myTopnav">
		<a href="<%= request.getContextPath() %>/home" class="active">Home</a>
		<a href="<%= request.getContextPath() %>/leaveFormPage">Apply for leave</a>      
		<a href="<%= request.getContextPath() %>/viewLeaveHistory">View Leave History</a>    
		<a href="<%= request.getContextPath() %>/updateSelfDetails">Update my details</a>
	    <a href="<%= request.getContextPath() %>/getDetails">Generate payslip for Employees</a>
	    <a href="<%= request.getContextPath() %>/addEmployee">Add an employee</a>
	    <a href="<%= request.getContextPath() %>/updateEmployeeDetails">Update Employee Profile</a>  
	    <a href="<%= request.getContextPath() %>/viewAllEmployees">View Employee list</a>            
	    <a href="<%= request.getContextPath() %>/getDetailsToverifyInvestmentProofs">Investment proof Approval</a>
	    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
			<i class="fa fa-bars"></i>
		</a>
	</div>