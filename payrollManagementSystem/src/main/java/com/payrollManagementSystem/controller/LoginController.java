package com.payrollManagementSystem.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.payrollManagementSystem.entity.Employee;
import com.payrollManagementSystem.entity.Login;
import com.payrollManagementSystem.service.EmployeeService;

/**
 * This Controller contains mappings for <b>/login, /login POST, /logout,
 * /home</b>
 * 
 * @author mahad
 *
 */
@Controller
public class LoginController {

	private static String[] userType = { "Employee", "Accountant", "Administrator" };
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/login")
	public String loginView(Model model, HttpSession session) {
		if (null != (Employee) session.getAttribute("employee")) {
			return "redirect:/home";
		}
		model.addAttribute("login", new Login());
		model.addAttribute("userType", userType);
		return "loginPage";
	}

	@PostMapping(value = "/login")
	public String loginAuthView(@Validated @ModelAttribute("login") Login login, BindingResult result, Model model,
			HttpSession session) {
		// First, to check for errors in the form input submitted
		if (null != (Employee) session.getAttribute("employee")) {
			return "redirect:/home";
		}
		if (result.hasErrors()) {
			model.addAttribute("login", login);
			model.addAttribute("userType", userType);
			// return the received input object back to login page
			return "loginPage";
		}
		// if no errors, validate given input with database
		else if (employeeService.validateEmployee(login)) {
			session.setAttribute("employee", employeeService.getEmployee(login.getEmployeeId()));
			return "redirect:/home";
		}
		// if authentication fails return "access denied" page
		model.addAttribute("status", "Authentication failed");
		model.addAttribute("statusMessage", "Sorry. Login failed. Please try again.");
		return "statusPage";
	}

	@RequestMapping(value = "/logout")
	public String logoutView(Model model, HttpSession session) {
		session.invalidate();
		model.addAttribute("status", "Logged out");
		model.addAttribute("statusMessage",
				"You're logged out successfully. It's a good practice to close all browser sessions after logging out :)");
		return "statusPage";
	}

	@RequestMapping(value = "/home")
	public String homePage(Model model, HttpServletResponse response, HttpSession session) {
		Employee employee = (Employee) session.getAttribute("employee");
		if (null == employee) {
			model.addAttribute("status", "Error");
			model.addAttribute("statusMessage", "Employee attribute is null");
			return "statusPage";
		}
		return "application/homepageViews/home";
	}
}
