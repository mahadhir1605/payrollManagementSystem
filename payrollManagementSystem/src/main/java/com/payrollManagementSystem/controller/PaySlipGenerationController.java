package com.payrollManagementSystem.controller;

import java.time.Month;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.payrollManagementSystem.entity.DataTransferEntity;
import com.payrollManagementSystem.entity.Employee;
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
	public ModelAndView getInfo(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = (Employee) session.getAttribute("employee");
		if(null == employee) {
			return new ModelAndView("statusPage");
		}
	
		modelAndView.addObject("dataTransferEntity", new DataTransferEntity());
		modelAndView.addObject("months", Month.values());
		modelAndView.setViewName("application/generatePayslipViews/infoGatheringPage");
		return modelAndView;
	}

	@RequestMapping(value = "/confirmationPage", method = RequestMethod.POST)
	public ModelAndView confirmation(@Valid DataTransferEntity dataTransferEntity, BindingResult result, HttpSession session)
			throws EmployeeNotFoundException, DuplicateRecordException, NoAttendanceException {
		ModelAndView modelAndView = new ModelAndView();

		Employee employee = (Employee) session.getAttribute("employee");
		if(null == employee) {
			return new ModelAndView("statusPage");
		}
		
		if (result.hasErrors()) {
			// System.out.println(result);
			modelAndView.addObject("dataTransferEntity", dataTransferEntity);
			modelAndView.addObject("months", Month.values());
			modelAndView.setViewName("application/generatePayslipViews/infoGatheringPage");
			return modelAndView;
		}

		PaySlipEntity paySlip = paySlipService.makePaySlip(dataTransferEntity.getEmployeeId(),
				dataTransferEntity.getMonth(), dataTransferEntity.getYear());
		session.setAttribute("paySlip", paySlip);
		//modelAndView.addObject("paySlip", paySlip);
		//modelAndView.addObject("paySlip2", new PaySlipEntity());
		modelAndView.setViewName("application/generatePayslipViews/confirmationPage");
		return modelAndView;
	}

	@RequestMapping(value = "/generationCompletionPage")
	public ModelAndView showCompletionMsg(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = (Employee) session.getAttribute("employee");
		if(null == employee) {
			return new ModelAndView("statusPage");
		}
		
		PaySlipEntity paySlip = (PaySlipEntity) session.getAttribute("paySlip");
		session.removeAttribute("paySlip");
		paySlipService.generatePaySlip(paySlip);
		modelAndView.addObject("completionMsg", "PaySlip is generated.");
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
