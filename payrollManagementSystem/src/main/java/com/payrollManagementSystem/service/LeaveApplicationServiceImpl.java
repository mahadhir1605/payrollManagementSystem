package com.payrollManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payrollManagementSystem.dao.EmployeeAvailableLeavesDao;
import com.payrollManagementSystem.dao.LeaveDao;
import com.payrollManagementSystem.entity.EmployeeAvailableLeaves;
import com.payrollManagementSystem.entity.LeaveData;
import com.payrollManagementSystem.exceptions.EarnedLeavesException;
import com.payrollManagementSystem.exceptions.EmergencyLeavesException;
import com.payrollManagementSystem.exceptions.SickLeavesException;

@Service
public class LeaveApplicationServiceImpl implements LeaveApplicationService {

	@Autowired
	private LeaveDao leaveDao;
	
	@Autowired
	private EmployeeAvailableLeavesDao employeeAvailableLeavesDao;
	

	@Override
	public void applyForLeave(LeaveData leaveData) throws EarnedLeavesException, SickLeavesException, EmergencyLeavesException {
		
		EmployeeAvailableLeaves employeeAvailableLeaves = employeeAvailableLeavesDao.getDataById(leaveData.getEmployeeId());
		
		if(leaveData.getLeaveType().equals("Earned Leave"))
		{
			if(leaveData.getTotalDays() <= employeeAvailableLeaves.getEarnedLeaves())
			{
				employeeAvailableLeaves.setEarnedLeaves(employeeAvailableLeaves.getEarnedLeaves() - leaveData.getTotalDays());
				employeeAvailableLeavesDao.updateEntry(employeeAvailableLeaves);
			}
			else
			{
				throw new EarnedLeavesException("You have only " + employeeAvailableLeaves.getEarnedLeaves() 
				+" Earned leaves. Please apply accordingly");
			}
		}
		else if(leaveData.getLeaveType().equals("Sick Leave"))
		{
			if(leaveData.getTotalDays() <= employeeAvailableLeaves.getSickLeaves())
			{
				employeeAvailableLeaves.setSickLeaves(employeeAvailableLeaves.getSickLeaves() - leaveData.getTotalDays());
				employeeAvailableLeavesDao.updateEntry(employeeAvailableLeaves);
				
			}
			else
			{
				throw new SickLeavesException("You have only " + employeeAvailableLeaves.getSickLeaves() 
				+" Sick leaves. Please apply accordingly");
			}
		}
		else
		{
			if(leaveData.getTotalDays() <= employeeAvailableLeaves.getEmergencyLeaves())
			{
				employeeAvailableLeaves.setEmergencyLeaves(employeeAvailableLeaves.getEmergencyLeaves() - leaveData.getTotalDays());
				employeeAvailableLeavesDao.updateEntry(employeeAvailableLeaves);
				
			}
			else
			{
				throw new EmergencyLeavesException("You have only " + employeeAvailableLeaves.getEmergencyLeaves() 
				+" Emergency leaves. Please apply accordingly");
			}
		}
		
		leaveDao.addLeaveRecord(leaveData);
		
	}


	@Override
	public List<LeaveData> getLeaveData(Long employeeId) {
		
		return leaveDao.getLeaveDataById(employeeId);
	}

}
