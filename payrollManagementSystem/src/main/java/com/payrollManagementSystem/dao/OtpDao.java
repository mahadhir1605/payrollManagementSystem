package com.payrollManagementSystem.dao;

import com.payrollManagementSystem.entity.Otp;

public interface OtpDao {
	void addOtpEntry(Otp otpObject);

	Otp getMappedOtp(int employeeId);

	boolean validateOtp(Otp otp);
}
