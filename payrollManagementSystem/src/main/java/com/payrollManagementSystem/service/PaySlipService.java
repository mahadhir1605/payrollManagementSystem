package com.payrollManagementSystem.service;

import com.payrollManagementSystem.entity.PaySlipEntity;
import com.payrollManagementSystem.exceptions.DuplicateRecordException;
import com.payrollManagementSystem.exceptions.EmployeeNotFoundException;
import com.payrollManagementSystem.exceptions.NoAttendanceException;

public interface PaySlipService {
	public PaySlipEntity makePaySlip(Long employeeId, String month, Integer year)
			throws EmployeeNotFoundException, DuplicateRecordException, NoAttendanceException;

	public void generatePaySlip(PaySlipEntity paySlip);

	public PaySlipEntity getPaySlipRecord(Long employeeId, String month, Integer year);

}
