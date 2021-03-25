package com.payrollManagementSystem.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.payrollManagementSystem.entity.InvestmentProofs;
import com.payrollManagementSystem.exceptions.DuplicateSubmissionException;
import com.payrollManagementSystem.service.EmployeeService;
import com.payrollManagementSystem.service.InvestmentProofsService;

@Controller
public class SubmittingInvestmentProofsController {

	@Autowired
	InvestmentProofsService investmentProofsService;
	
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/uploadFiles")
	public ModelAndView getUploadData(@CookieValue(name = "userId", defaultValue = "0") long userId) {
		ModelAndView modelAndView = new ModelAndView();

		// URL bypass check
		if (userId == 0) {
			modelAndView.addObject("status", "Session invalid or expired");
			modelAndView.addObject("statusMessage",
					"You are trying an invalid request or your current session has expired. Please log in again");
			modelAndView.setViewName("statusPage");
			return modelAndView;
		}

		String[] financialYears = { "2020-21", "2021-22", "2022-23", "2023-24", "2024-25" };
		modelAndView.addObject("financialYears", financialYears);
		InvestmentProofs inv = new InvestmentProofs();
		inv.setEmployeeid(userId);
		modelAndView.addObject("employee", employeeService.getEmployee(userId));
		modelAndView.addObject("investmentProofs", inv);
		// modelAndView.addObject("multipartEntity", new MultipartEntity());
		modelAndView.setViewName("application/investmentProofViews/uploadingPage");
		return modelAndView;
	}

	@RequestMapping(value = "/uploadSuccess")
	public ModelAndView uploadSuccess(@CookieValue(name = "userId", defaultValue = "0") long userId,
			@Valid InvestmentProofs investmentProofs, BindingResult result)
			throws IOException, DuplicateSubmissionException {
		ModelAndView modelAndView = new ModelAndView();

		// URL bypass check
		if (userId == 0) {
			modelAndView.addObject("status", "Session invalid or expired");
			modelAndView.addObject("statusMessage",
					"You are trying an invalid request or your current session has expired. Please log in again");
			modelAndView.setViewName("statusPage");
			return modelAndView;
		}


		if (result.hasErrors()) {
			String[] financialYears = { "2020-21", "2021-22", "2022-23", "2023-24", "2024-25" };

			modelAndView.addObject("financialYears", financialYears);
			modelAndView.addObject("investmentProofs", investmentProofs);
			modelAndView.addObject("employee", employeeService.getEmployee(userId));
			// modelAndView.addObject("multipartEntity", new MultipartEntity());
			modelAndView.setViewName("application/investmentProofViews/uploadingPage");
			return modelAndView;
		}

		if (investmentProofs.getHouseRentAllowanceFile().isEmpty()
				|| investmentProofs.getChildernTutionFeeFile().isEmpty()
				|| investmentProofs.getEducationLoanInterestFile().isEmpty()
				|| investmentProofs.getMedicalInsuranceFile().isEmpty()
				|| investmentProofs.getMutualFundsFile().isEmpty()) {

			String[] financialYears = { "2020-21", "2021-22", "2022-23", "2023-24", "2024-25" };
			modelAndView.addObject("financialYears", financialYears);
			modelAndView.addObject("investmentProofs", investmentProofs);
			// modelAndView.addObject("multipartEntity", new MultipartEntity());
			modelAndView.setViewName("application/investmentProofViews/uploadingPage");
			modelAndView.addObject("employee", employeeService.getEmployee(userId));
			modelAndView.addObject("UploadErrorMsg", "Please upload all the files.");
			return modelAndView;
		}

		investmentProofsService.uploadProofs(investmentProofs);
		modelAndView.addObject("SuccessMessage", "Proofs uploaded Successfully.");
		modelAndView.addObject("employee", employeeService.getEmployee(userId));
		modelAndView.setViewName("application/investmentProofViews/uploadSuccessPage");
		return modelAndView;
	}

	@ExceptionHandler(DuplicateSubmissionException.class)
	public ModelAndView submissionExceptionHandling(DuplicateSubmissionException e) {
		String[] financialYears = { "2020-21", "2021-22", "2022-23", "2023-24", "2024-25" };
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("financialYears", financialYears);
		modelAndView.addObject("investmentProofs", new InvestmentProofs());
		// modelAndView.addObject("multipartEntity", new MultipartEntity());
		modelAndView.addObject("UploadErrorMsg", e.getMessage());
		modelAndView.setViewName("application/investmentProofViews/uploadingPage");

		return modelAndView;
	}

}
