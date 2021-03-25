package com.payrollManagementSystem.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employee") 
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long employeeId;
	@Column(name = "emp_name")
	private String employeeName;
	@Column(name = "department")
	private String department;
	@Column(name = "designation")
	private String designation;
	@Column(name = "date_of_birth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	@Column(name = "date_of_joining")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfJoining;
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;
	@Column(name = "bank_acc_no")
	private Long bankAccNum;
	@Column(name = "phone_num")
	private Long phoneNum;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "password")
	private String password;
	@Column(name = "usertype")
	private String usertype;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	private EmployeeCtc employeeCtc;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Long getBankAccNum() {
		return bankAccNum;
	}

	public void setBankAccNum(Long bankAccNum) {
		this.bankAccNum = bankAccNum;
	}

	public Long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public EmployeeCtc getEmployeeCtc() {
		return employeeCtc;
	}

	public void setEmployeeCtc(EmployeeCtc employeeCtc) {
		this.employeeCtc = employeeCtc;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", department=" + department
				+ ", designation=" + designation + ", dateOfBirth=" + dateOfBirth + ", dateOfJoining=" + dateOfJoining
				+ ", gender=" + gender + ", bankAccNum=" + bankAccNum + ", phoneNum=" + phoneNum + ", emailId="
				+ emailId + ", password=" + password + ", usertype=" + usertype + ", employeeCtc=" + employeeCtc + "]";
	}

}
