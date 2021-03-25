package com.payrollManagementSystem.entity;

import javax.validation.constraints.NotNull;

public class DataTransferEntity {

	@NotNull(message = "Please enter Employee Id.")
	private Long employeeId;
	private String month;
	@NotNull(message = "Please enter Year.")
	private Integer year;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
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

}
