package com.payrollManagementSystem.dao;

import java.util.List;

import com.payrollManagementSystem.entity.Employee;
import com.payrollManagementSystem.entity.Login;

public interface EmployeeDao {

	boolean validateEmployee(Login login);

	void addEmployee(Employee employee);

	List<Employee> getAllEmployees();

	void deleteEmployee(long employeeId);

	Employee getEmployee(long employeeId);

	Employee updateEmployee(Employee employee);

	void updatePassword(Employee employee);
	
	void updateEmployeeAllDetails(Employee employee);
	
	List<Employee> getAllAccountants();

//	boolean isEmployeeExists(long employeeId);
}
