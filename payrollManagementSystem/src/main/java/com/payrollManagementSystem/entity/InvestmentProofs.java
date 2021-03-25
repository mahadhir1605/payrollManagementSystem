package com.payrollManagementSystem.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="investment_proofs")
public class InvestmentProofs {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RECORD_ID")
	private Long recordId;
	
	@Column(name="employee_id")
	private Long employeeid;
	
	@Column(name="financial_year")
	private String financialYear;
	
	@Lob
	@Column(name="hra_file_bytes")
	private byte[] houseRentAllowanceFileBytes;
	
	@NotNull(message="This field cannot be blank")
	@Range(min=0, max=120000)
	@Column(name="hra_amount")
	private Double houseRentAllowanceAmount;
	
	@Lob
	@Column(name="childern_tution_fee_file_bytes")
	private byte[] childernTutionFeeFileBytes;
	
	@NotNull(message="This field cannot be blank")
	@Range(min=0, max=150000)
	@Column(name="childern_tution_fee_amount")
	private Double childernTutionFeeAmount;
	
	@Lob
	@Column(name="education_loan_interest_file_bytes")
	private byte[] educationLoanInterestFileBytes;
	
	@NotNull(message="This field cannot be blank")
	@Column(name="education_loan_interest_amount")
	private Double educationLoanInterestAmount;
	@Lob
	@Column(name="medical_insurance_file_bytes")
	private byte[] medicalInsuranceFileBytes;
	
	@NotNull(message="This field cannot be blank")
	@Range(min=0, max=25000)
	@Column(name="medical_insurance_amount")
	private Double medicalInsuranceAmount;
	
	@Lob
	@Column(name="mutual_funds_file_bytes")
	private byte[] mutualFundsFileBytes;
	
	@NotNull(message="This field cannot be blank")
	@Range(min=0, max=150000)
	@Column(name="mutual_funds_amount")
	private Double mutualFundsAmount;
	
	@Column(name="status_")
	private String status = "SUBMITTED";
	
	
	@Transient
	private MultipartFile houseRentAllowanceFile;
	
	@Transient
	private MultipartFile childernTutionFeeFile;
	
	@Transient
	private MultipartFile educationLoanInterestFile;
	
	@Transient
	private MultipartFile medicalInsuranceFile;
	
	@Transient
	private MultipartFile mutualFundsFile;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getRecordId() {
		return recordId;
	}
	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}
	public Long getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Long employeeid) {
		this.employeeid = employeeid;
	}
	public String getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	public byte[] getHouseRentAllowanceFileBytes() {
		return houseRentAllowanceFileBytes;
	}
	public void setHouseRentAllowanceFileBytes(byte[] houseRentAllowanceFileBytes) {
		this.houseRentAllowanceFileBytes = houseRentAllowanceFileBytes;
	}
	public Double getHouseRentAllowanceAmount() {
		return houseRentAllowanceAmount;
	}
	public void setHouseRentAllowanceAmount(Double houseRentAllowanceAmount) {
		this.houseRentAllowanceAmount = houseRentAllowanceAmount;
	}
	public byte[] getChildernTutionFeeFileBytes() {
		return childernTutionFeeFileBytes;
	}
	public void setChildernTutionFeeFileBytes(byte[] childernTutionFeeFileBytes) {
		this.childernTutionFeeFileBytes = childernTutionFeeFileBytes;
	}
	public Double getChildernTutionFeeAmount() {
		return childernTutionFeeAmount;
	}
	public void setChildernTutionFeeAmount(Double childernTutionFeeAmount) {
		this.childernTutionFeeAmount = childernTutionFeeAmount;
	}
	public byte[] getEducationLoanInterestFileBytes() {
		return educationLoanInterestFileBytes;
	}
	public void setEducationLoanInterestFileBytes(byte[] educationLoanInterestFileBytes) {
		this.educationLoanInterestFileBytes = educationLoanInterestFileBytes;
	}
	public Double getEducationLoanInterestAmount() {
		return educationLoanInterestAmount;
	}
	public void setEducationLoanInterestAmount(Double educationLoanInterestAmount) {
		this.educationLoanInterestAmount = educationLoanInterestAmount;
	}
	public byte[] getMedicalInsuranceFileBytes() {
		return medicalInsuranceFileBytes;
	}
	public void setMedicalInsuranceFileBytes(byte[] medicalInsuranceFileBytes) {
		this.medicalInsuranceFileBytes = medicalInsuranceFileBytes;
	}
	public Double getMedicalInsuranceAmount() {
		return medicalInsuranceAmount;
	}
	public void setMedicalInsuranceAmount(Double medicalInsuranceAmount) {
		this.medicalInsuranceAmount = medicalInsuranceAmount;
	}
	public byte[] getMutualFundsFileBytes() {
		return mutualFundsFileBytes;
	}
	public void setMutualFundsFileBytes(byte[] mutualFundsFileBytes) {
		this.mutualFundsFileBytes = mutualFundsFileBytes;
	}
	public Double getMutualFundsAmount() {
		return mutualFundsAmount;
	}
	public void setMutualFundsAmount(Double mutualFundsAmount) {
		this.mutualFundsAmount = mutualFundsAmount;
	}
	
	
	public MultipartFile getHouseRentAllowanceFile() {
		return houseRentAllowanceFile;
	}
	public void setHouseRentAllowanceFile(MultipartFile houseRentAllowanceFile) {
		this.houseRentAllowanceFile = houseRentAllowanceFile;
	}
	public MultipartFile getChildernTutionFeeFile() {
		return childernTutionFeeFile;
	}
	public void setChildernTutionFeeFile(MultipartFile childernTutionFeeFile) {
		this.childernTutionFeeFile = childernTutionFeeFile;
	}
	public MultipartFile getEducationLoanInterestFile() {
		return educationLoanInterestFile;
	}
	public void setEducationLoanInterestFile(MultipartFile educationLoanInterestFile) {
		this.educationLoanInterestFile = educationLoanInterestFile;
	}
	public MultipartFile getMedicalInsuranceFile() {
		return medicalInsuranceFile;
	}
	public void setMedicalInsuranceFile(MultipartFile medicalInsuranceFile) {
		this.medicalInsuranceFile = medicalInsuranceFile;
	}
	public MultipartFile getMutualFundsFile() {
		return mutualFundsFile;
	}
	public void setMutualFundsFile(MultipartFile mutualFundsFile) {
		this.mutualFundsFile = mutualFundsFile;
	}
	@Override
	public String toString() {
		return "InvestmentProofs [recordId=" + recordId + ", employeeid=" + employeeid + ", financialYear="
				+ financialYear + ", houseRentAllowanceFileBytes=" + Arrays.toString(houseRentAllowanceFileBytes)
				+ ", houseRentAllowanceAmount=" + houseRentAllowanceAmount + ", childernTutionFeeFileBytes="
				+ Arrays.toString(childernTutionFeeFileBytes) + ", childernTutionFeeAmount=" + childernTutionFeeAmount
				+ ", educationLoanInterestFileBytes=" + Arrays.toString(educationLoanInterestFileBytes)
				+ ", educationLoanInterestAmount=" + educationLoanInterestAmount + ", medicalInsuranceFileBytes="
				+ Arrays.toString(medicalInsuranceFileBytes) + ", medicalInsuranceAmount=" + medicalInsuranceAmount
				+ ", mutualFundsFileBytes=" + Arrays.toString(mutualFundsFileBytes) + ", mutualFundsAmount="
				+ mutualFundsAmount + ", status=" + status + "]";
	}
	
	
	
}
