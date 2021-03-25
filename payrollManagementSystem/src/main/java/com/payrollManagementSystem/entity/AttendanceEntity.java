package com.payrollManagementSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_Attendance")
public class AttendanceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RECORD_ID")
	private Long recordId;
	@Column(name = "emp_id")
	private Long employeeId;
	// @Enumerated(EnumType.STRING)
	@Column(name = "month_")
	private String month;
	@Column(name = "year_")
	private Integer year;
	@Column(name = "LOP_days")
	private Integer LOPDays;

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Long getEmployeeid() {
		return employeeId;
	}

	public void setEmployeeid(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getLOPDays() {
		return LOPDays;
	}

	public void setLOPDays(Integer lOPDays) {
		LOPDays = lOPDays;
	}

	@Override
	public String toString() {
		return "AttendanceEntity [recordId=" + recordId + ", employeeId=" + employeeId + ", month=" + month + ", year="
				+ year + ", LOPDays=" + LOPDays + "]";
	}

}
