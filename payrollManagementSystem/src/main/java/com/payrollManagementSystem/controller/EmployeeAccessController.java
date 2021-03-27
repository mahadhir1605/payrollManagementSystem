package com.payrollManagementSystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.payrollManagementSystem.entity.Employee;
import com.payrollManagementSystem.entity.Gender;
import com.payrollManagementSystem.service.EmployeeService;

@Controller
public class EmployeeAccessController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/addEmployee")
	public String addEmployee(Model m, HttpSession session) {
		if(null == (Employee) session.getAttribute("employee")) {
			return "statusPage";
		}

		Employee newEmployee = new Employee(); newEmployee.setUsertype("Employee");
		m.addAttribute("newEmployee", newEmployee);
		m.addAttribute("gender", Gender.values());
		return "application/employeeAccessViews/addEmployeeForm";
	}
	
	@PostMapping(value = "/addEmployee")
	public String addEmployeeSubmission(@ModelAttribute("newEmployee") Employee employee ,Model m, HttpSession session) {
		if(null == (Employee) session.getAttribute("employee")) {
			return "statusPage";
		}
		
		employeeService.addEmployee(employee);
		m.addAttribute("e", employee);
		return "application/employeeAccessViews/addEmployeeStatus";
	}
	
	@RequestMapping(value = "/viewAllEmployees")
	public String viewAllEmployeesList(HttpSession session, Model m) {
		if(null == (Employee) session.getAttribute("employee")) {
			return "statusPage";
		}
		m.addAttribute("employeeList", employeeService.getAllEmployees());
		return "application/employeeAccessViews/viewAllEmployees";
	}
	
	@RequestMapping(value = "/viewAllEmployees/delete/{employeeId}")
	public String deleteEmployeeById(HttpSession session, Model m, @PathVariable("employeeId") long employeeId ) {
		if(null == (Employee) session.getAttribute("employee")) {
			return "statusPage";
		}
		
		employeeService.deleteEmployee(employeeId);
		return "redirect:/viewAllEmployees";
	}
	
	@RequestMapping(value = "/viewAllEmployees/edit/{employeeId}")
	public String editEmployeeById(HttpSession session, Model m, @PathVariable("employeeId") long employeeId) {
		if(null == (Employee) session.getAttribute("employee")) {
			return "statusPage";
		}
		
		m.addAttribute("editEmployee", employeeService.getEmployee(employeeId));
		m.addAttribute("gender", Gender.values());
		return "application/employeeAccessViews/editEmployee";
		
	}
	
	@PostMapping(value = "/viewAllEmployees/edit/{employeeId}")
	public String editEmployeeByIdSubmit(@ModelAttribute("editEmployee") Employee emp, HttpSession session, Model m, @PathVariable("employeeId")long employeeId)	{
		employeeService.updateEmployeeAllDetails(emp);
		return "redirect:/viewAllEmployees";
	}
	
	@RequestMapping(value = "/addAccountantUser")
	public String addAccountantUser(HttpSession session, Model m) {
		if(null == (Employee) session.getAttribute("employee")) {
			return "statusPage";
		}
		Employee emp = new Employee();
		emp.setUsertype("Accountant");
		m.addAttribute("newAccountant", emp);
		m.addAttribute("gender", Gender.values());
		return "application/employeeAccessViews/addAccountantForm";
	}
	
	@PostMapping(value = "/addAccountantUser")
	public String addAccountantSubmission(HttpSession session, @ModelAttribute("newAccountant")Employee employee, Model m) {
		if(null == (Employee) session.getAttribute("employee")) {
			return "statusPage";
		}

		employeeService.addEmployee(employee);
		m.addAttribute("e", employee);
		return "application/employeeAccessViews/addAccountantStatus";
	}

	@RequestMapping(value = "/viewAllAccountants")
	public String viewAllAccountants(HttpSession session, Model m) {
		if(null == (Employee) session.getAttribute("employee")) {
			return "statusPage";
		}
		m.addAttribute("employeeList", employeeService.getAllAccountants());
		return "application/employeeAccessViews/viewAllAccountants";
	}
	
	@RequestMapping(value = "/viewAllAccountants/delete/{employeeId}")
	public String deleteAccountantbyId(HttpSession session, @PathVariable("employeeId")long employeeId) {
		if(null == (Employee) session.getAttribute("employee")) {
			return "statusPage";
		}
		employeeService.deleteEmployee(employeeId);
		return "redirect:/viewAllAccountants";
	}
	
	@RequestMapping(value = "/viewAllAccountants/edit/{employeeId}")
	public String editAccountantById(HttpSession session, Model m, @PathVariable("employeeId")long employeeId) {
		if(null == (Employee) session.getAttribute("employee")) {
			return "statusPage";
		}
		
		m.addAttribute("editAccountant", employeeService.getEmployee(employeeId));
		m.addAttribute("gender", Gender.values());
		return "application/employeeAccessViews/editAccountant";
	}
	
	@PostMapping(value = "/viewAllAccountants/edit/{employeeId}")
	public String editAccountantByIdSubmit(HttpSession session, @ModelAttribute("newAccountant")Employee employee, @PathVariable("employeeId")long employeeId) {
		if(null == (Employee) session.getAttribute("employee")) {
			return "statusPage";
		}
		
		employeeService.updateEmployeeAllDetails(employee);
		return "redirect:/viewAllAccountants";
	}
}
