package com.payrollManagementSystem.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payrollManagementSystem.dao.OtpDao;
import com.payrollManagementSystem.entity.Otp;

@Service
@Transactional
public class OtpServiceImpl implements OtpService {
	@Autowired
	OtpDao otpDao;

	public void addOtpEntry(Otp otpObject) {
		otpDao.addOtpEntry(otpObject);
	}

	public Otp getMappedOtp(int employeeId) {
		return otpDao.getMappedOtp(employeeId);
	}

	public boolean validateOtp(Otp otp) {
		return otpDao.validateOtp(otp);
	}

}
