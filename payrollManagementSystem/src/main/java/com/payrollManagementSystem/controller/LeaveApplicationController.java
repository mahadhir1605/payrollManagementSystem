package com.payrollManagementSystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.payrollManagementSystem.entity.Employee;
import com.payrollManagementSystem.entity.EmployeeIdEntity;
import com.payrollManagementSystem.entity.LeaveData;
import com.payrollManagementSystem.exceptions.EarnedLeavesException;
import com.payrollManagementSystem.exceptions.EmergencyLeavesException;
import com.payrollManagementSystem.exceptions.SickLeavesException;
import com.payrollManagementSystem.service.EmployeeService;
import com.payrollManagementSystem.service.LeaveApplicationService;

@Controller
public class LeaveApplicationController {
	@Autowired
	LeaveApplicationService leaveApplicationService;

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/leaveFormPage")
	public ModelAndView getLeaveData(HttpSession session) {
		Employee employee = (Employee) session.getAttribute("employee");
		if(null == employee) {
			return new ModelAndView("statusPage");
		}

		ModelAndView modelAndView = new ModelAndView();
		
		LeaveData leaveData = new LeaveData();
		leaveData.setEmployeeId(employee.getEmployeeId());
		String[] leaveTypes = { "Earned Leave", "Sick Leave", "Emergency Leave" };
		modelAndView.addObject("leaveData", leaveData);
		modelAndView.addObject("leaveTypes", leaveTypes);
		modelAndView.setViewName("application/leaveApplicationViews/leaveApplicationForm");
		return modelAndView;

	}

	@RequestMapping(value = "/leaveResultPage", method = RequestMethod.POST)
	public ModelAndView showLeaveData(@Valid LeaveData leaveData, BindingResult result, HttpSession session)
			throws EarnedLeavesException, SickLeavesException, EmergencyLeavesException {
		Employee employee = (Employee) session.getAttribute("employee");
		if(null == employee) {
			return new ModelAndView("statusPage");
		}
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(leaveData);
		System.out.println(result.getAllErrors());
		if (result.hasErrors()) {
			leaveData.setEndDate(null);
			leaveData.setStartDate(null);
			leaveData.setTotalDays(0);
			String[] leaveTypes = { "Earned Leave", "Sick Leave", "Emergency Leave" };
			modelAndView.addObject("leaveTypes", leaveTypes);
			modelAndView.addObject("leaveData", leaveData);
			modelAndView.setViewName("application/leaveApplicationViews/leaveApplicationForm");
		} else {

			leaveApplicationService.applyForLeave(leaveData);
			modelAndView.addObject("LD", leaveData);
			modelAndView.addObject("employeeIdEntity", new EmployeeIdEntity());
			modelAndView.setViewName("application/leaveApplicationViews/leaveApplicationResult");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/viewLeaveHistory")
	public ModelAndView showLeaveData(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = (Employee) session.getAttribute("employee");
		if(null == employee) {
			return new ModelAndView("statusPage");
		}
		List<LeaveData> list = leaveApplicationService.getLeaveData(employee.getEmployeeId());
		System.out.println(list);
		if (null == list) { // if no leave data, it redirects to leave application page itself
			LeaveData leaveData = new LeaveData();
			leaveData.setEmployeeId(employee.getEmployeeId());
			String[] leaveTypes = { "Earned Leave", "Sick Leave", "Emergency Leave" };
			modelAndView.addObject("leaveData", leaveData);
			modelAndView.addObject("leaveTypes", leaveTypes);
			modelAndView.addObject("message", "No leave record found");
			modelAndView.setViewName("application/leaveApplicationViews/leaveApplicationForm");
			return modelAndView;
		}
		System.err.println(list);
		modelAndView.addObject("listOfLeaveData", list);
		modelAndView.setViewName("application/leaveApplicationViews/searchResultOfLeaveData");
		return modelAndView;
	}

	@ExceptionHandler({ EarnedLeavesException.class, SickLeavesException.class, EmergencyLeavesException.class })
	public ModelAndView exceptionHandling( Exception e) {
		// System.out.println(leaveData);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("errorMsg", e.getMessage());
//		leaveData.setEndDate(null);
//		leaveData.setStartDate(null);
//		leaveData.setTotalDays(0);
		String[] leaveTypes = { "Earned Leave", "Sick Leave", "Emergency Leave" };
		modelAndView.addObject("leaveTypes", leaveTypes);
		modelAndView.addObject("leaveData", new LeaveData());
		modelAndView.setViewName("application/leaveApplicationViews/leaveApplicationForm");
		// modelAndView.setViewName("earnedLeaveExceptionPage");
		return modelAndView;
	}

}
