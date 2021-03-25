package com.payrollManagementSystem.service;

import java.io.IOException;
import com.payrollManagementSystem.entity.InvestmentProofs;
import com.payrollManagementSystem.entity.VerificationDetailsEntity;
import com.payrollManagementSystem.exceptions.DuplicateApprovalException;
import com.payrollManagementSystem.exceptions.DuplicateSubmissionException;
import com.payrollManagementSystem.exceptions.NoRecordFoundException;
import com.payrollManagementSystem.exceptions.RejectedRecordException;

public interface InvestmentProofsService {

	public void uploadProofs(InvestmentProofs investmentProofs) throws IOException, DuplicateSubmissionException;

	public InvestmentProofs getInvestmentProofsDetailsForVerification(
			VerificationDetailsEntity verificationDetailsEntity)
			throws IOException, DuplicateApprovalException, NoRecordFoundException, RejectedRecordException;

	public void approveInvestmentProofs(VerificationDetailsEntity verificationDetailsEntity);

	public void rejectInvestmentProofs(VerificationDetailsEntity verificationDetailsEntity);

}
