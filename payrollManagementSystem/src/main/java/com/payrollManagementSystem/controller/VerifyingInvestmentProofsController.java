package com.payrollManagementSystem.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.payrollManagementSystem.entity.Employee;
import com.payrollManagementSystem.entity.InvestmentProofs;
import com.payrollManagementSystem.entity.VerificationDetailsEntity;
import com.payrollManagementSystem.exceptions.DuplicateApprovalException;
import com.payrollManagementSystem.exceptions.NoRecordFoundException;
import com.payrollManagementSystem.exceptions.RejectedRecordException;
import com.payrollManagementSystem.service.EmployeeService;
import com.payrollManagementSystem.service.InvestmentProofsService;

@Controller
public class VerifyingInvestmentProofsController {

	@Autowired
	InvestmentProofsService investmentProofsService;

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/getDetailsToverifyInvestmentProofs")
	public ModelAndView getInvestmentProofsDetails(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();

		Employee employee = (Employee) session.getAttribute("employee");
		if (null == employee) {
			return new ModelAndView("statusPage");
		}

		String[] financialYears = { "2020-21", "2021-22", "2022-23", "2023-24", "2024-25" };
		modelAndView.addObject("financialYears", financialYears);
		modelAndView.addObject("verificationDetailsEntity", new VerificationDetailsEntity());
		modelAndView.setViewName("application/investmentProofViews/infoForInvestmentProofsPage");
		return modelAndView;
	}

	@RequestMapping(value = "/detailsToBeVerified", method = RequestMethod.POST) // POST
	public ModelAndView showInvestmentDetails(@Valid VerificationDetailsEntity verificationDetailsEntity,
			BindingResult result, HttpSession session)
			throws IOException, DuplicateApprovalException, NoRecordFoundException, RejectedRecordException {
		ModelAndView modelAndView = new ModelAndView();

		Employee employee = (Employee) session.getAttribute("employee");
		if (null == employee) {
			return new ModelAndView("statusPage");
		}

		if (result.hasErrors()) {
			String[] financialYears = { "2020-21", "2021-22", "2022-23", "2023-24", "2024-25" };
			modelAndView.addObject("financialYears", financialYears);
			modelAndView.addObject("verificationDetailsEntity", verificationDetailsEntity);
			modelAndView.setViewName("application/investmentProofViews/infoForInvestmentProofsPage");
			return modelAndView;
		}

		InvestmentProofs investmentProofs = investmentProofsService
				.getInvestmentProofsDetailsForVerification(verificationDetailsEntity);

		Path pathToCreateDirectory = Paths.get("/PDFs");
		if (!Files.exists(pathToCreateDirectory)) {
			Files.createDirectories(pathToCreateDirectory);
		}

		String path = "/PDFs/";

		String fileName = verificationDetailsEntity.getEmployeeId() + "_proof1.pdf";

		File file = new File(path + fileName);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(investmentProofs.getHouseRentAllowanceFileBytes());
		fos.close();

		fileName = verificationDetailsEntity.getEmployeeId() + "_proof2.pdf";
		file = new File(path + fileName);
		fos = new FileOutputStream(file);
		fos.write(investmentProofs.getChildernTutionFeeFileBytes());
		fos.close();

		fileName = verificationDetailsEntity.getEmployeeId() + "_proof3.pdf";
		file = new File(path + fileName);
		fos = new FileOutputStream(file);
		fos.write(investmentProofs.getEducationLoanInterestFileBytes());
		fos.close();

		fileName = verificationDetailsEntity.getEmployeeId() + "_proof4.pdf";
		file = new File(path + fileName);
		fos = new FileOutputStream(file);
		fos.write(investmentProofs.getMedicalInsuranceFileBytes());
		fos.close();

		fileName = verificationDetailsEntity.getEmployeeId() + "_proof5.pdf";
		file = new File(path + fileName);
		fos = new FileOutputStream(file);
		fos.write(investmentProofs.getMutualFundsFileBytes());
		fos.close();

		modelAndView.addObject("investmentProofs", investmentProofs);
		modelAndView.addObject("verificationDetailsEntity", new VerificationDetailsEntity());
		modelAndView.setViewName("application/investmentProofViews/InvestmentProofsDetails");
		return modelAndView;
	}

	@RequestMapping(value = "/viewProof/{fileName}")
	public void showProof1PDF(HttpServletResponse response, HttpSession session, @PathVariable String fileName)
			throws IOException {

		fileName = fileName + ".pdf";
		String path = "/PDFs/";
		File file = new File(path + fileName);

		FileInputStream fis = new FileInputStream(file);

		response.setContentType("application/pdf");
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "inline;filename=\"" + fileName + "\"");

		FileCopyUtils.copy(fis, response.getOutputStream());
	}

	@RequestMapping(value = "investmentProofsStatus/{status}")
	public ModelAndView investmentProofsApproving(@PathVariable String status,
			VerificationDetailsEntity verificationDetailsEntity, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = (Employee) session.getAttribute("employee");
		if (null == employee) {
			return new ModelAndView("statusPage");
		}
		if (status.equals("APPROVED")) {
			investmentProofsService.approveInvestmentProofs(verificationDetailsEntity);
			modelAndView.addObject("StatusChangeMsg", "Investment proofs have been approved.");
			modelAndView.setViewName("application/investmentProofViews/ProofsStatusChangePage");
			return modelAndView;
		}

		investmentProofsService.rejectInvestmentProofs(verificationDetailsEntity);
		modelAndView.addObject("StatusChangeMsg", "Investment proofs have been rejected.");
		modelAndView.setViewName("application/investmentProofViews/ProofsStatusChangePage");
		return modelAndView;

	}

	@ExceptionHandler({ DuplicateApprovalException.class, NoRecordFoundException.class, RejectedRecordException.class })
	public ModelAndView exceptionHandling(Exception e) {
		e.printStackTrace();
		String[] financialYears = { "2020-21", "2021-22", "2022-23", "2023-24", "2024-25" };
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("financialYears", financialYears);
		modelAndView.addObject("verificationDetailsEntity", new VerificationDetailsEntity());
		modelAndView.addObject("ExceptionMsg", e.getMessage());
		modelAndView.setViewName("application/investmentProofViews/infoForInvestmentProofsPage");
		return modelAndView;
	}

	@ExceptionHandler(IOException.class)
	public ModelAndView IOExceptionHandling(IOException e) {
		e.printStackTrace();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("ErrorMsg",
				"We have encountered an error in " + "getting the files. Please try again after some time.");
		modelAndView.setViewName("application/investmentProofViews/IOExceptionPage");
		return modelAndView;
	}

}
