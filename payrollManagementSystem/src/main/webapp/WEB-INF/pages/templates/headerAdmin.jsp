<div>
		<h2 style="text-align: center;">Employee Portal</h2>
	</div>
	<div style="padding-right: 3%;">
		<p align="right">Logged in as ${employee.employeeName }</p>
		<p align="right"><a href="logout">Logout</a>
	</div>

	<div class="topnav" id="myTopnav">
		<a href="<%= request.getContextPath() %>/home" class="active">Home</a>
		<a href="<%= request.getContextPath() %>/updateSelfDetails">Update my details</a>
	    <a href="<%= request.getContextPath() %>/generatePayroll">Generate payroll for Employees</a>
	    <a href="<%= request.getContextPath() %>/addAccountantUser">Add Accountant</a>
	    <a href="<%= request.getContextPath() %>/viewAllAccountants">View or edit Accountants list</a> <a></a>   
	</div>