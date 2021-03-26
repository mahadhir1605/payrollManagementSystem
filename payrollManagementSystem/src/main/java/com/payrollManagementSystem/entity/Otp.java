package com.payrollManagementSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "otptracker")
public class Otp {
	@Column
	@Id
	int employeeId;
	@Column
	int otp;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public Otp(int employeeId, int otp) {
		super();
		this.employeeId = employeeId;
		this.otp = otp;
	}

	public Otp() {

	}

	public Otp(int employeeId) {
		super();
		this.employeeId = employeeId;
	}

}
