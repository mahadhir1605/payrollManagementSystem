package com.payrollManagementSystem.dao;

import java.util.List;

import com.payrollManagementSystem.entity.InvestmentProofs;

public interface InvestmentProofsDao {

	public void addEntry(InvestmentProofs investmentProofs);

	public List<InvestmentProofs> getRecordListByIdAndFinancialYear(Long employeeId, String financialYear);

	public void setStatusApproved(Long employeeId, String financialYear);

	public void setStatusRejected(Long employeeId, String financialYear);
}
