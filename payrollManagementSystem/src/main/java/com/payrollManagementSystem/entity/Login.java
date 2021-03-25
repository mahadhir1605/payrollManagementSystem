package com.payrollManagementSystem.entity;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Login {
	@NotNull
	@Digits(integer = 7, fraction = 0)
	private long employeeId;
	@NotEmpty
	@Size(min = 8, max = 12)
	private String password;
	private String userType;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [employeeId=" + employeeId + ", password=" + password + ", userType=" + userType + "]";
	}

}