package com.payrollManagementSystem.controller;

import java.util.Random;

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
	public String forgotPasswordView(@ModelAttribute("login") Login login, Model m, HttpSession session) {
		m.addAttribute("login", login);
		return "forgotPassword";
	}

	@PostMapping(value = "/forgotPassword")
	public String forgotPasswordDisplayOtpPage(@ModelAttribute("login") Login login, Model model, HttpSession session) {

		Employee employee = employeeService.getEmployee(login.getEmployeeId());
		if (null != employee) {
			Otp otp = new Otp(login.getEmployeeId(), new Random().nextInt(8999) + 1000);
			otpService.addOtpEntry(otp); // to generate and store otp in database
			if (MailerService.generateOTP(employee.getEmailId(), otp.getOtp()) == 1) { // check mail status
				System.out.println("Mail sent to " + employee.getEmailId());
			} else {
				System.err.println("ERROR : Mail not sent");
			}
			model.addAttribute("Otp", new Otp(employee.getEmployeeId()));
			return "forgotPasswordFlow";
		}
		model.addAttribute("status", "Error");
		model.addAttribute("statusMessage", "No such employee exist");
		return "statusPage";
	}

	@PostMapping(value = "/otpAuth")
	public String validateOtp(@ModelAttribute("Otp") Otp otp, Model m, HttpSession session) {
		// if true, OTP is correct, redirect to changePassword page
		if (otpService.validateOtp(otp)) {
			m.addAttribute("employee", employeeService.getEmployee(otp.getEmployeeId()));
			return "changePasswordPage";
		}
		m.addAttribute("status", "fail");
		m.addAttribute("statusMessage", "auth fail");
		return "statusPage";
	}

	@PostMapping(value = "/changePassword")
	public String updateNewPassword(@Validated @ModelAttribute("employee") Employee employee, BindingResult result, Model m, HttpSession session) {
		if (result.hasErrors()) {
			m.addAttribute("employee", employee);
			return "changePasswordPage";
		}
		employeeService.updatePassword(employee);
		session.setAttribute("employee", employee);
			return "redirect:/home";
	}
}
