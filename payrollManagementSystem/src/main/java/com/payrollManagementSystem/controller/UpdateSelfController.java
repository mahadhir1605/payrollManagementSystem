package com.payrollManagementSystem.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.payrollManagementSystem.entity.Employee;
import com.payrollManagementSystem.service.EmployeeService;

/**
 * This Controller contains mappings for <b>/updateSelfDetails,
 * /updateSelfDetails POST</b>
 * 
 * @author mahad
 *
 */
@Controller
public class UpdateSelfController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/updateSelfDetails")
	public String updateSelfDetails(Model model, @CookieValue(name = "userId", defaultValue = "0") int userId,
			HttpServletResponse response) {
		// URL bypass check
		if (userId == 0) {
			model.addAttribute("status", "Session invalid or expired");
			model.addAttribute("statusMessage",
					"You are trying an invalid request or your current session has expired. Please log in again");
			return "statusPage";
		}
		Employee currentEmployee = employeeService.getEmployee(userId);
		model.addAttribute("employee", currentEmployee);
		return "application/updateSelfDetails";
	}

	@RequestMapping(value = "/updateSelfDetails", method = RequestMethod.POST)
	public String saveSelfDetails(@Validated @ModelAttribute("employee") Employee employee, BindingResult result,
			@CookieValue(name = "userId", defaultValue = "0") int userId, HttpServletResponse response, Model model) {
		// URL bypass check
		if (userId == 0) {
			model.addAttribute("status", "Session invalid or expired");
			model.addAttribute("statusMessage",
					"You are trying an invalid request or your current session has expired. Please log in again");
			return "statusPage";
		}
		if (result.hasErrors()) {
			System.out.println(employee + "\n" + result.getAllErrors());
			model.addAttribute("employee", employee);
			return "application/updateSelfDetails";
		}
		employeeService.updateEmployee(employee);
		return "redirect:/home";
	}
}
