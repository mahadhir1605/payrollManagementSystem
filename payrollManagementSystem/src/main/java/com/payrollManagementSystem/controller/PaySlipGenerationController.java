package com.payrollManagementSystem.controller;

import java.time.Month;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.payrollManagementSystem.entity.DataTransferEntity;
import com.payrollManagementSystem.entity.PaySlipEntity;
import com.payrollManagementSystem.exceptions.DuplicateRecordException;
import com.payrollManagementSystem.exceptions.EmployeeNotFoundException;
import com.payrollManagementSystem.exceptions.NoAttendanceException;
import com.payrollManagementSystem.service.EmployeeService;
import com.payrollManagementSystem.service.PaySlipService;

@Controller
public class PaySlipGenerationController {

	@Autowired
	PaySlipService paySlipService;

	@Autowired
	EmployeeService employeeService;
	
	
	@RequestMapping(value = "/getDetails")
	public ModelAndView getInfo(@CookieValue(name = "userId", defaultValue = "0") int userId,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();

		// URL bypass check
		if (userId == 0) {
			modelAndView.addObject("status", "Session invalid or expired");
			modelAndView.addObject("statusMessage",
					"You are trying an invalid request or your current session has expired. Please log in again");
			modelAndView.setViewName("statusPage");
			return modelAndView;
		}
		modelAndView.addObject("employee", employeeService.getEmployee(userId));
		modelAndView.addObject("dataTransferEntity", new DataTransferEntity());
		modelAndView.addObject("months", Month.values());
		modelAndView.setViewName("application/generatePayslipViews/infoGatheringPage");
		return modelAndView;
	}

	@RequestMapping(value = "/confirmationPage", method = RequestMethod.POST)
	public ModelAndView confirmation(@Valid DataTransferEntity dataTransferEntity, BindingResult result,
			@CookieValue(name = "userId", defaultValue = "0") int userId, HttpServletResponse response)
			throws EmployeeNotFoundException, DuplicateRecordException, NoAttendanceException {
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
			// System.out.println(result);
			modelAndView.addObject("dataTransferEntity", dataTransferEntity);
			modelAndView.addObject("months", Month.values());
			modelAndView.addObject("employee", employeeService.getEmployee(userId));
			modelAndView.setViewName("application/generatePayslipViews/infoGatheringPage");
			return modelAndView;
		}

		PaySlipEntity paySlip = paySlipService.makePaySlip(dataTransferEntity.getEmployeeId(),
				dataTransferEntity.getMonth(), dataTransferEntity.getYear());
		modelAndView.addObject("paySlip", paySlip);
		modelAndView.addObject("paySlip2", new PaySlipEntity());
		modelAndView.addObject("employee", employeeService.getEmployee(userId));
		modelAndView.setViewName("application/generatePayslipViews/confirmationPage");
		return modelAndView;
	}

	@RequestMapping(value = "/generationCompletionPage")
	public ModelAndView showCompletionMsg(PaySlipEntity paySlip2,
			@CookieValue(name = "userId", defaultValue = "0") int userId, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		// URL bypass check
		if (userId == 0) {
			modelAndView.addObject("status", "Session invalid or expired");
			modelAndView.addObject("statusMessage",
					"You are trying an invalid request or your current session has expired. Please log in again");
			modelAndView.setViewName("statusPage");

			return modelAndView;
		}
		paySlipService.generatePaySlip(paySlip2);
		modelAndView.addObject("completionMsg", "PaySlip is generated.");
		modelAndView.addObject("employee", employeeService.getEmployee(userId));
		modelAndView.setViewName("application/generatePayslipViews/completionPage");
		return modelAndView;
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ModelAndView employeeExceptionHandling(EmployeeNotFoundException e) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("EmployeeErrorMsg", e.getMessage());
		modelAndView.addObject("dataTransferEntity", new DataTransferEntity());
		modelAndView.addObject("months", Month.values());
		modelAndView.setViewName("application/generatePayslipViews/infoGatheringPage");
		return modelAndView;
	}

	@ExceptionHandler(DuplicateRecordException.class)
	public ModelAndView DuplicateRecordExceptionHandling(DuplicateRecordException e) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("DuplicateRecordErrorMsg", e.getMessage());
		modelAndView.addObject("dataTransferEntity", new DataTransferEntity());
		modelAndView.addObject("months", Month.values());
		modelAndView.setViewName("application/generatePayslipViews/infoGatheringPage");
		return modelAndView;
	}

	@ExceptionHandler(NoAttendanceException.class)
	public ModelAndView AttedanceExceptionHandling(NoAttendanceException e) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("AttendanceErrorMsg", e.getMessage());
		modelAndView.addObject("dataTransferEntity", new DataTransferEntity());
		modelAndView.addObject("months", Month.values());
		modelAndView.setViewName("application/generatePayslipViews/infoGatheringPage");
		return modelAndView;
	}

}
