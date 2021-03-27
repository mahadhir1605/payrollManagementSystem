package com.payrollManagementSystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payrollManagementSystem.dao.EmployeeDao;
import com.payrollManagementSystem.entity.Employee;
import com.payrollManagementSystem.entity.Login;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public boolean validateEmployee(Login login) {
		return employeeDao.validateEmployee(login);
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public void deleteEmployee(long employeeId) {
		employeeDao.deleteEmployee(employeeId);
	}

	@Override
	public Employee getEmployee(long employeeId) {
		return employeeDao.getEmployee(employeeId);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	@Override
	public void updatePassword(Employee employee) {
		employeeDao.updatePassword(employee);
	}

	@Override
	public void updateEmployeeAllDetails(Employee employee) {
		employeeDao.updateEmployeeAllDetails(employee);
	}

}
