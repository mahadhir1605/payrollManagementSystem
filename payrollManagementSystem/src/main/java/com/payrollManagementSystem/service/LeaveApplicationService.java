package com.payrollManagementSystem.service;

import java.util.List;

import com.payrollManagementSystem.entity.LeaveData;
import com.payrollManagementSystem.exceptions.EarnedLeavesException;
import com.payrollManagementSystem.exceptions.EmergencyLeavesException;
import com.payrollManagementSystem.exceptions.SickLeavesException;

public interface LeaveApplicationService {
	
	public void applyForLeave(com.payrollManagementSystem.entity.LeaveData leaveData) throws EarnedLeavesException, SickLeavesException, EmergencyLeavesException;
	public List<LeaveData> getLeaveData(Long employeeId);

}
