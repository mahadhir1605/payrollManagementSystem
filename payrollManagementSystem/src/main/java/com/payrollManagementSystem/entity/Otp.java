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
	long employeeId;
	@Column
	int otp;

	public long getEmployeeId() {
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

	public Otp(long l, int otp) {
		super();
		this.employeeId = l;
		this.otp = otp;
	}

	public Otp() {

	}

	public Otp(long employeeId) {
		super();
		this.employeeId = employeeId;
	}

}
