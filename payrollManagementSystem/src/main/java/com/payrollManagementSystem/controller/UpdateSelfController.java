package com.payrollManagementSystem.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public String updateSelfDetails(Model model,HttpSession session) {
		Employee employee = (Employee) session.getAttribute("employee");
		if(null == employee) {
			return "statusPage";
		}
		model.addAttribute("employee", employee);
		return "application/updateSelfDetails";
	}

	@RequestMapping(value = "/updateSelfDetails", method = RequestMethod.POST)
	public String saveSelfDetails(@Validated @ModelAttribute("employee") Employee emp, BindingResult result,
			HttpSession session, Model model) {
		Employee employee = (Employee) session.getAttribute("employee");
		if(null == employee) {
			return "statusPage";
		}
		if (result.hasErrors()) {
			model.addAttribute("employee", emp);
			return "application/updateSelfDetails";
		}
		employeeService.updateEmployee(emp);
		return "redirect:/home";
	}
}
