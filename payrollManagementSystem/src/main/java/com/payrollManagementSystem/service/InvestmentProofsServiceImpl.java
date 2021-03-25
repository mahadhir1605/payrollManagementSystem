package com.payrollManagementSystem.service;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payrollManagementSystem.exceptions.DuplicateApprovalException;
import com.payrollManagementSystem.dao.InvestmentProofsDao;
import com.payrollManagementSystem.entity.InvestmentProofs;
import com.payrollManagementSystem.entity.VerificationDetailsEntity;
import com.payrollManagementSystem.exceptions.DuplicateSubmissionException;
import com.payrollManagementSystem.exceptions.NoRecordFoundException;
import com.payrollManagementSystem.exceptions.RejectedRecordException;

@Service
public class InvestmentProofsServiceImpl implements InvestmentProofsService{
	
	@Autowired
	InvestmentProofsDao investmentProofsDao;

	public void uploadProofs(InvestmentProofs investmentProofs) throws IOException, DuplicateSubmissionException {
		investmentProofs.setHouseRentAllowanceFileBytes(investmentProofs.getHouseRentAllowanceFile().getBytes());
		investmentProofs.setChildernTutionFeeFileBytes(investmentProofs.getChildernTutionFeeFile().getBytes());
		investmentProofs.setEducationLoanInterestFileBytes(investmentProofs.getEducationLoanInterestFile().getBytes());
		investmentProofs.setMedicalInsuranceFileBytes(investmentProofs.getMedicalInsuranceFile().getBytes());
		investmentProofs.setMutualFundsFileBytes(investmentProofs.getMutualFundsFile().getBytes());
		
		List<InvestmentProofs> list = investmentProofsDao.getRecordListByIdAndFinancialYear
						(investmentProofs.getEmployeeid(), investmentProofs.getFinancialYear());
		//checking the latest entry for duplicate entry.
		if(!list.isEmpty())
		{
			InvestmentProofs investmentsProofs1 = list.get(list.size()-1);
			if (investmentsProofs1.getStatus().equals("APPROVED") || investmentsProofs1.getStatus().equals("SUBMITTED"))
			{
				throw new DuplicateSubmissionException("You have already submitted the "
						+ "investment proofs for entered details.");
			}
		}
		
		
//		if(!list.isEmpty())
//		{
//			for(InvestmentProofs ip : list)
//			{
//				if(ip.getStatus().equals("APPROVED") || ip.getStatus().equals("SUBMITTED"))
//				{
//					throw new DuplicateSubmissionException("You have already submitted the "
//							+ "investment proofs for entered details.");
//				}
//			}
//			
//		}
		
		investmentProofsDao.addEntry(investmentProofs);
		
	}

	public InvestmentProofs getInvestmentProofsDetailsForVerification(VerificationDetailsEntity verificationDetailsEntity) 
			throws IOException, DuplicateApprovalException, NoRecordFoundException, RejectedRecordException {
		List<InvestmentProofs> list = investmentProofsDao.getRecordListByIdAndFinancialYear
				(verificationDetailsEntity.getEmployeeId(), verificationDetailsEntity.getFinancialYear());
		
		if(list.isEmpty())
		{
			throw new NoRecordFoundException("There are no investments proofs documents avialable for the given details.");
		}
		
		InvestmentProofs investmentProofs = list.get(list.size() - 1);
		
		if(investmentProofs.getStatus().equals("REJECTED"))
		{
			throw new RejectedRecordException("The employee yet to provide the investments proofs after rejection.");
		}
		
		if(investmentProofs.getStatus().equals("APPROVED"))
		{
			throw new DuplicateApprovalException("The investments proofs are already "
						+ "approved for the given details.");
		}
			
		
//		for (InvestmentProofs ip:list)
//		{
//			if(ip.getStatus().equals("APPROVED"))
//				throw new DuplicateApprovalException("The investments proofs are already approved for the given details.");
//		}
		
		return investmentProofs;
	}

	public void approveInvestmentProofs(VerificationDetailsEntity verificationDetailsEntity) {
		
		investmentProofsDao.setStatusApproved
		(verificationDetailsEntity.getEmployeeId(), verificationDetailsEntity.getFinancialYear());
	}

	public void rejectInvestmentProofs(VerificationDetailsEntity verificationDetailsEntity) {
		
		investmentProofsDao.setStatusRejected
		(verificationDetailsEntity.getEmployeeId(), verificationDetailsEntity.getFinancialYear());
	}

	

}
