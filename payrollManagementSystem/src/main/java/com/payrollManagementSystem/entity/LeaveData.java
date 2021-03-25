package com.payrollManagementSystem.entity;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="leavedata")
public class LeaveData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RECORD_ID")
	private Long recordId;
	
	@NotNull(message="Must provide Employee ID")
	@Column(name="EMPLOYEE_ID")
	private Long employeeId;
	
	@Column(name="LEAVE_TYPE")
	private String leaveType;
	
	@Future
	@NotNull(message="start Date cannot be null.")
	@Column(name="START_DATE")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;
	
	@Future
	@NotNull(message="end Date cannot be null")
	@Column(name="END_DATE")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate endDate;
	
	@NotNull
	@Range(min=1, max=5, message="number of Days should be greater than 0 and less than 5")
	@Column(name="TOTAL_DAYS")
	private Integer totalDays;
	
	@Size(max=100, message="Only 100 characters are allowed.")
	@NotBlank(message="Please enter reason.")
	@Column(name="REASON")
	private String reason;
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
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Integer getTotalDays() {
		return totalDays;
	}
	public void setTotalDays(Integer totalDays) {
		this.totalDays = totalDays;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "LeaveData [recordId=" + recordId + ", employeeId=" + employeeId + ", leaveType=" + leaveType
				+ ", totalDays=" + totalDays + ", reason=" + reason + "]";
	}

}
