package com.payrollManagementSystem.controller;

import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
import com.payrollManagementSystem.entity.Otp;
import com.payrollManagementSystem.service.EmployeeService;
import com.payrollManagementSystem.service.MailerService;
import com.payrollManagementSystem.service.OtpService;

@Controller
public class ForgotPasswordControler {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private OtpService otpService;

	@RequestMapping(value = "/forgotPassword")
	public String forgotPasswordView(@ModelAttribute("login") Login login, Model m, HttpServletResponse response) {
		m.addAttribute("login", login);
		return "forgotPassword";
	}

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public String forgotPasswordDisplayOtpPage(@ModelAttribute("login") Login login,
			@CookieValue(value = "recoverUser", defaultValue = "0") int otpCookie, Model model,
			HttpServletRequest request, HttpServletResponse response) {

		// received employeeId from forgotpassword form
		String employeeId = request.getParameter("employeeId");
		int id = Integer.valueOf(employeeId);
//		int id = login.getEmployeeId();

		Cookie cookie = new Cookie("recoverUser", String.valueOf(id));
		cookie.setPath("/payrollManagementSystem");
		if (null != employeeService.getEmployee(id)) {
			Otp otp = new Otp(id, new Random().nextInt(8999) + 1000);
			otpService.addOtpEntry(otp); // to generate and store otp in database
			String email = employeeService.getEmployee(id).getEmailId();
			response.addCookie(cookie);// add a cookie to identify the user who is trying to recover
			if (MailerService.generateOTP(email, otp.getOtp()) == 1) { // check mail status
				System.out.println("Mail sent to " + email);
			} else {
				System.err.println("ERROR : Mail not sent");
			}
			model.addAttribute("Otp", new Otp(id));

			return "forgotPasswordFlow";
		}
		model.addAttribute("status", "Error");
		model.addAttribute("statusMessage", "No such employee exist");
		return "statusPage";
	}

	@RequestMapping(value = "/otpAuth", method = RequestMethod.POST)
	public String validateOtp(@CookieValue("recoverUser") int recoverUser, @ModelAttribute("Otp") Otp otp, Model m,
			HttpServletResponse response) {
		// if true, OTP is correct, redirect to changePassword page
		Cookie cookie = new Cookie("recoverUser", null); // clear cookie no matter what, true or false
		cookie.setMaxAge(0);
		cookie.setPath("/payrollManagementSystem"); // expire cookie
		if (otpService.validateOtp(otp)) {
			m.addAttribute("employee", employeeService.getEmployee(recoverUser));
			return "changePasswordPage";
		}
		m.addAttribute("status", "fail");
		m.addAttribute("statusMessage", "auth fail");
		response.addCookie(cookie);
		return "statusPage";
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String updateNewPassword(@CookieValue("recoverUser") int recoverUser, HttpServletResponse response,
			@Validated @ModelAttribute("employee") Employee employee, BindingResult result, Model m) {
		System.err.println(employee);
		System.err.println("HAS ERROR + " + result.hasErrors());
		if (result.hasErrors()) {
			System.out.println(employee);
			System.out.println(result.getAllErrors());
			m.addAttribute("employee", employee);
			return "changePasswordPage";
		}
		employeeService.updatePassword(employee);
		Cookie cookie = new Cookie("recoverUser", null);
		cookie.setMaxAge(0);
		cookie.setPath("/payrollManagementSystem");
		Cookie cookie2 = new Cookie("userId", String.valueOf(employee.getEmployeeId()));
		cookie2.setMaxAge(600);
		cookie2.setPath("/payrollManagementSystem");
		response.addCookie(cookie);
		response.addCookie(cookie2);
		return "redirect:/home";
	}
}
