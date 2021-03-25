package com.payrollManagementSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_ctc")
public class EmployeeCtc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long employeeId;
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
	@Column(name = "PF")
	private Double PF;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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

	public Double getPF() {
		return PF;
	}

	public void setPF(Double pF) {
		PF = pF;
	}

	@Override
	public String toString() {
		return "EmployeeCtc [employeeId=" + employeeId + ", basicSalary=" + basicSalary + ", specialAllowance="
				+ specialAllowance + ", HRA=" + HRA + ", LTA=" + LTA + ", foodCoupon=" + foodCoupon + ", PF=" + PF
				+ "]";
	}

}