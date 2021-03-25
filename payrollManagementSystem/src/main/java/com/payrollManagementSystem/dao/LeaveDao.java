package com.payrollManagementSystem.dao;

import java.util.List;

import com.payrollManagementSystem.entity.LeaveData;

public interface LeaveDao {
	
	public void addLeaveRecord(LeaveData leaveData);
	public List<LeaveData> getLeaveDataById(Long employeeId);

}