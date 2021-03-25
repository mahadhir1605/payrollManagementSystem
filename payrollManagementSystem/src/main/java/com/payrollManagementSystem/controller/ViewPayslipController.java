package com.payrollManagementSystem.controller;

import java.time.Month;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.payrollManagementSystem.entity.DataTransferEntity;
import com.payrollManagementSystem.entity.PaySlipEntity;
import com.payrollManagementSystem.exceptions.DuplicateRecordException;
import com.payrollManagementSystem.exceptions.EmployeeNotFoundException;
import com.payrollManagementSystem.exceptions.NoAttendanceException;
import com.payrollManagementSystem.service.EmployeeService;
import com.payrollManagementSystem.service.PaySlipService;

@Controller
public class ViewPayslipController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	PaySlipService paySlipService;

	@RequestMapping(value = "/viewPayslip")
	public String viewPayslipEntryPage(Model model, @CookieValue(name = "userId", defaultValue = "0") long userId,
			HttpServletResponse response) {
		// URL bypass check
		if (userId == 0) {
			model.addAttribute("status", "Session invalid or expired");
			model.addAttribute("statusMessage",
					"You are trying an invalid request or your current session has expired. Please log in again");
			return "statusPage";
		}

		model.addAttribute("dataTransferEntity", new DataTransferEntity());
		model.addAttribute("employee", employeeService.getEmployee(userId));
		model.addAttribute("months", Month.values());

		return "application/viewPayslipViews/viewPayslipEntryPage";
	}

	@RequestMapping(value = "/viewPayslip", method = RequestMethod.POST)
	public String viewPayslipOnSubmit(@CookieValue(name = "userId", defaultValue = "0") long userId, Model model,
			HttpServletResponse response, DataTransferEntity dataTransferEntity, BindingResult result,
			HttpServletRequest request)
			throws DuplicateRecordException, NoAttendanceException, EmployeeNotFoundException {
		// URL bypass check
		if (userId == 0) {
			model.addAttribute("status", "Session invalid or expired");
			model.addAttribute("statusMessage",
					"You are trying an invalid request or your current session has expired. Please log in again");
			return "application/viewPayslipViews/viewPayslipEntryPage";
		}
		model.addAttribute("employee", employeeService.getEmployee(userId));
		System.err.println(result.hasErrors());
		if (result.hasErrors()) {

			model.addAttribute("dataTransferEntity", new DataTransferEntity());
			model.addAttribute("months", Month.values());
			return "application/viewPayslipViews/viewPayslipEntryPage";

		}
		PaySlipEntity payslip = paySlipService.getPaySlipRecord(userId, dataTransferEntity.getMonth(),
				dataTransferEntity.getYear());
		System.err.println(payslip);
		if (null == payslip) {
			model.addAttribute("PayslipNotAvailableError", "Payslip not generated yet!");
			model.addAttribute("dataTransferEntity", new DataTransferEntity());
			model.addAttribute("months", Month.values());
			return "application/viewPayslipViews/viewPayslipEntryPage";

		}
		model.addAttribute("paySlip", payslip);
		return "application/viewPayslipViews/viewPayslip";

	}
}
