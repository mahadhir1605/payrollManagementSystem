package com.payrollManagementSystem.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class VerificationDetailsEntity {
	
	@NotNull(message="This field cannot be blank.")
	@Range(min=0, message="Enter a valid employee id.")
	private Long employeeId;
	
	private String financialYear;
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

}
