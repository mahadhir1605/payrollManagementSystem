package com.payrollManagementSystem.controller;

import javax.servlet.http.Cookie;
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
	public String loginView(Model model, @CookieValue(name = "userId", defaultValue = "0") int userId,
			HttpServletResponse response) {
		if (userId != 0) {
			return "redirect:/home";
		}
		model.addAttribute("login", new Login());
		model.addAttribute("userType", userType);
		return "loginPage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginAuthView(@Validated @ModelAttribute("login") Login login, BindingResult result, Model model,
			@CookieValue(value = "userId", defaultValue = "0") int userId, HttpServletResponse response) {
		// First, to check for errors in the form input submitted
		System.out.println(login);
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			model.addAttribute("login", login);
			model.addAttribute("userType", userType);
			// return the received input object back to login page
			return "loginPage";
		}
		// if no errors, validate given input with database
		else if (employeeService.validateEmployee(login)) {
			// as the user logged in, a cookie is created in browser session with name
			// `userId`
			Cookie cookie = new Cookie("userId", String.valueOf(login.getEmployeeId()));
			cookie.setPath("/payrollManagementSystem");
			cookie.setMaxAge(6000); // setting active session for 10 mins
			response.addCookie(cookie);
			System.out.println("LOGGED IN USER ID : " + login.getEmployeeId());
			model.addAttribute("employee", employeeService.getEmployee(login.getEmployeeId()));
			return "redirect:/home";
		}
		// if authentication fails return "access denied" page
		model.addAttribute("status", "Authentication failed");
		model.addAttribute("statusMessage", "Sorry. Login failed. Please try again.");
		return "statusPage";
	}

	@RequestMapping(value = "/logout")
	public String logoutView(@CookieValue(value = "userId", defaultValue = "0") int userId,
			HttpServletResponse response, Model model) {
		// clearing the cookie on logout
		Cookie cookie = new Cookie("userId", null);
		cookie.setPath("/payrollManagementSystem");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		model.addAttribute("status", "Logged out");
		model.addAttribute("statusMessage",
				"You're logged out successfully. It's a good practice to close all browser sessions after logging out :)");
		return "statusPage";
	}

	@RequestMapping(value = "/home")
	public String homePage(Model model, @CookieValue(name = "userId", defaultValue = "0") int userId,
			HttpServletResponse response) {
		// URL bypass check
		if (userId == 0) {
			model.addAttribute("status", "Session invalid or expired");
			model.addAttribute("statusMessage",
					"You are trying an invalid request or your current session has expired. Please log in again");
			return "statusPage";
		}
		Employee currentEmployee = employeeService.getEmployee(userId);
		System.out.println(currentEmployee);
		model.addAttribute("employee", currentEmployee);
		// to display homepage relevant to the current user type
		if (currentEmployee.getUsertype().equals("Administrator")) {
			return "application/homepageViews/AdministratorHome";
		}
		if (currentEmployee.getUsertype().equals("Accountant")) {
			return "application/homepageViews/AccountantHome";
		}
		return "application/homepageViews/EmployeeHome";
	}
}
