package com.payrollManagementSystem.service;

import com.payrollManagementSystem.entity.Otp;

public interface OtpService {
	void addOtpEntry(Otp otpObject);

	Otp getMappedOtp(long employeeId);

	boolean validateOtp(Otp otp);

}
