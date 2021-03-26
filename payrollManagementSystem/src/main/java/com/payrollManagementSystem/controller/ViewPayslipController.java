package com.payrollManagementSystem.controller;

import java.time.Month;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.payrollManagementSystem.entity.DataTransferEntity;
import com.payrollManagementSystem.entity.Employee;
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
	public String viewPayslipEntryPage(Model model, HttpSession session) {
		Employee employee = (Employee) session.getAttribute("employee");
		if(null == employee) {
			return "statusPage";
		}
		model.addAttribute("dataTransferEntity", new DataTransferEntity());
		model.addAttribute("months", Month.values());

		return "application/viewPayslipViews/viewPayslipEntryPage";
	}

	@RequestMapping(value = "/viewPayslip", method = RequestMethod.POST)
	public String viewPayslipOnSubmit( Model model, DataTransferEntity dataTransferEntity, BindingResult result,
			HttpSession session)
			throws DuplicateRecordException, NoAttendanceException, EmployeeNotFoundException {
		// URL bypass check
		Employee employee = (Employee) session.getAttribute("employee");
		if(null == employee) {
			return "statusPage";
		}
		if (result.hasErrors()) {

			model.addAttribute("dataTransferEntity", new DataTransferEntity());
			model.addAttribute("months", Month.values());
			return "application/viewPayslipViews/viewPayslipEntryPage";

		}
		PaySlipEntity payslip = paySlipService.getPaySlipRecord(employee.getEmployeeId(), dataTransferEntity.getMonth(),
				dataTransferEntity.getYear());
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
