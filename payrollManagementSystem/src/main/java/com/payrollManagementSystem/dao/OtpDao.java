package com.payrollManagementSystem.dao;

import com.payrollManagementSystem.entity.Otp;

public interface OtpDao {
	void addOtpEntry(Otp otpObject);

	Otp getMappedOtp(long employeeId);

	boolean validateOtp(Otp otp);
}
