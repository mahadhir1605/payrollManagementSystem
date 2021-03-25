package com.payrollManagementSystem.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "payslip")
public class PaySlipEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RECORD_ID")
	private Long recordId;
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
	@Column(name = "bank_acc_num")
	private Long bankAccNum;
	@Column(name = "phone_num")
	private Long phoneNum;
	@Column(name = "email_id")
	private String emailId;

	@Column(name = "basic_salary")
	private Double basicSalary;
	@Column(name = "special_allowance")
	private Double specialAllowance;
	@Column(name = "HRA")
	private Double HRA;
	@Column(name = "LTA")
	private Double LTA;
	@Column(name = "food_coupon")
	private Double foodCoupon;
	@Column(name = "provident_fund")
	private Double providentFund;
	@Column(name = "professional_tax")
	private Double professionalTax;
	@Column(name = "LOP_deductions")
	private Double deductionsDueToLOP;
	@Column(name = "total_earnings")
	private Double totalEarnings;
	@Column(name = "total_deductions")
	private Double totalDeductions;
	@Column(name = "net_pay")
	private Double netPay;

	@Column(name = "month_")
	private String month;
	@Column(name = "year_")
	private Integer year;
	@Column(name = "days_in_month")
	private Integer numOfDaysInGivenMonth;
	@Column(name = "LOP_days")
	private Integer LOPDays;
	@Column(name = "net_days_worked")
	private Integer netDaysWorked;

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

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

	public Double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Double getSpecialAllowance() {
		return specialAllowance;
	}

	public void setSpecialAllowance(Double specialAllowance) {
		this.specialAllowance = specialAllowance;
	}

	public Double getHRA() {
		return HRA;
	}

	public void setHRA(Double hRA) {
		HRA = hRA;
	}

	public Double getLTA() {
		return LTA;
	}

	public void setLTA(Double lTA) {
		LTA = lTA;
	}

	public Double getFoodCoupon() {
		return foodCoupon;
	}

	public void setFoodCoupon(Double foodCoupon) {
		this.foodCoupon = foodCoupon;
	}

	public Double getProvidentFund() {
		return providentFund;
	}

	public void setProvidentFund(Double providentFund) {
		this.providentFund = providentFund;
	}

	public Double getProfessionalTax() {
		return professionalTax;
	}

	public void setProfessionalTax(Double professionalTax) {
		this.professionalTax = professionalTax;
	}

	public Double getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(Double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	public Double getTotalDeductions() {
		return totalDeductions;
	}

	public void setTotalDeductions(Double totalDeductions) {
		this.totalDeductions = totalDeductions;
	}

	public Double getNetPay() {
		return netPay;
	}

	public void setNetPay(Double netPay) {
		this.netPay = netPay;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getLOPDays() {
		return LOPDays;
	}

	public void setLOPDays(Integer lOPDays) {
		LOPDays = lOPDays;
	}

	public Integer getNetDaysWorked() {
		return netDaysWorked;
	}

	public void setNetDaysWorked(Integer netDaysWorked) {
		this.netDaysWorked = netDaysWorked;
	}

	public Integer getNumOfDaysInGivenMonth() {
		return numOfDaysInGivenMonth;
	}

	public void setNumOfDaysInGivenMonth(Integer numOfDaysInGivenMonth) {
		this.numOfDaysInGivenMonth = numOfDaysInGivenMonth;
	}

	public Double getDeductionsDueToLOP() {
		return deductionsDueToLOP;
	}

	public void setDeductionsDueToLOP(Double deductionsDueToLOP) {
		this.deductionsDueToLOP = deductionsDueToLOP;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "PaySlipEntity [recordId=" + recordId + ", employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", department=" + department + ", designation=" + designation + ", dateOfBirth=" + dateOfBirth
				+ ", dateOfJoining=" + dateOfJoining + ", gender=" + gender + ", bankAccNum=" + bankAccNum
				+ ", phoneNum=" + phoneNum + ", emailId=" + emailId + ", basicSalary=" + basicSalary
				+ ", specialAllowance=" + specialAllowance + ", HRA=" + HRA + ", LTA=" + LTA + ", foodCoupon="
				+ foodCoupon + ", providentFund=" + providentFund + ", professionalTax=" + professionalTax
				+ ", deductionsDueToLOP=" + deductionsDueToLOP + ", totalEarnings=" + totalEarnings
				+ ", totalDeductions=" + totalDeductions + ", netPay=" + netPay + ", month=" + month + ", year=" + year
				+ ", numOfDaysInGivenMonth=" + numOfDaysInGivenMonth + ", LOPDays=" + LOPDays + ", netDaysWorked="
				+ netDaysWorked + "]";
	}

}
