package com.payrollManagementSystem.dao;

import com.payrollManagementSystem.entity.AttendanceEntity;

public interface AttendanceDao {

	public void addAttendanceEntry(AttendanceEntity AttendanceEntity);

	public AttendanceEntity getAttendanceEntityOfGivenMonthAndYearById(Long employeeId, String month, Integer year);

}
