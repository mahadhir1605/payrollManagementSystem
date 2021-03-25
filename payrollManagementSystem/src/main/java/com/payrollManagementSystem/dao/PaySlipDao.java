package com.payrollManagementSystem.dao;

import com.payrollManagementSystem.entity.PaySlipEntity;

public interface PaySlipDao {

	public void addPaySlipRecord(PaySlipEntity paySlipEntity);

	public PaySlipEntity getPaySlipRecord(Long employeeId, String month, Integer year);

}
