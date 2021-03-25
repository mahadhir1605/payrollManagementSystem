package com.payrollManagementSystem.dao;

import com.payrollManagementSystem.entity.EmployeeAvailableLeaves;

public interface EmployeeAvailableLeavesDao {
	
	public void addEntry(Long employeeId);
	public EmployeeAvailableLeaves getDataById(Long employeeId);
	public void updateEntry(EmployeeAvailableLeaves employeeAvailableLeaves);

}
