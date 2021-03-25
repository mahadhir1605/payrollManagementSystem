package com.payrollManagementSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_available_leaves")
public class EmployeeAvailableLeaves {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RECORD_ID")
	private Long recordId;
	
	@Column(name="EMPLOYEE_ID")
	private Long employeeId;
	
	@Column(name="EARNED_LEAVES")
	private Integer earnedLeaves = 5;
	
	@Column(name="SICK_LEAVES")
	private Integer sickLeaves = 3;
	
	@Column(name="EMERGENCY_LEAVES")
	private Integer emergencyLeaves = 3;
	
	public Long getRecordId() {
		return recordId;
	}
	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getEarnedLeaves() {
		return earnedLeaves;
	}
	public void setEarnedLeaves(Integer earnedLeaves) {
		this.earnedLeaves = earnedLeaves;
	}
	public Integer getSickLeaves() {
		return sickLeaves;
	}
	public void setSickLeaves(Integer sickLeaves) {
		this.sickLeaves = sickLeaves;
	}
	public Integer getEmergencyLeaves() {
		return emergencyLeaves;
	}
	public void setEmergencyLeaves(Integer emergencyLeaves) {
		this.emergencyLeaves = emergencyLeaves;
	}
	@Override
	public String toString() {
		return "EmployeeAvailableLeaves [recordId=" + recordId + ", employeeId=" + employeeId + ", earnedLeaves="
				+ earnedLeaves + ", sickLeaves=" + sickLeaves + ", emergencyLeaves=" + emergencyLeaves + "]";
	}
	
	

}
