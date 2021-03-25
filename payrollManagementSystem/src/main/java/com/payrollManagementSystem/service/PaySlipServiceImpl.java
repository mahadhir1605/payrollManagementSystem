package com.payrollManagementSystem.service;

import java.text.DecimalFormat;
import java.time.Year;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payrollManagementSystem.dao.AttendanceDao;
import com.payrollManagementSystem.dao.EmployeeDao;
import com.payrollManagementSystem.dao.PaySlipDao;
import com.payrollManagementSystem.entity.AttendanceEntity;
import com.payrollManagementSystem.entity.Employee;
import com.payrollManagementSystem.entity.PaySlipEntity;
import com.payrollManagementSystem.exceptions.DuplicateRecordException;
import com.payrollManagementSystem.exceptions.EmployeeNotFoundException;
import com.payrollManagementSystem.exceptions.NoAttendanceException;

@Service
@Transactional
public class PaySlipServiceImpl implements PaySlipService {
	// private static final Double ProfessionTaxPerYear = 2500D;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private AttendanceDao attendanceDao;

	@Autowired
	private PaySlipDao paySlipDao;

	public PaySlipEntity makePaySlip(Long employeeId, String month, Integer year)
			throws EmployeeNotFoundException, DuplicateRecordException, NoAttendanceException {

		Employee employeeEntity = employeeDao.getEmployee(employeeId);

		if (employeeEntity == null) {
			throw new EmployeeNotFoundException("There is no employee with that ID.");
		}
		AttendanceEntity attendanceEntity = attendanceDao.getAttendanceEntityOfGivenMonthAndYearById(employeeId, month,
				year);
		if (attendanceEntity == null) {
			throw new NoAttendanceException("PaySlip generation is not allowed for that employee for" + month);
		}
		if (paySlipDao.getPaySlipRecord(employeeId, month, year) != null) {
			throw new DuplicateRecordException("PaySlip for the entered details had already been generated.");
		}

		PaySlipEntity paySlipEntity = new PaySlipEntity();
		paySlipEntity.setEmployeeId(employeeId);
		paySlipEntity.setEmployeeName(employeeEntity.getEmployeeName());
		paySlipEntity.setDepartment(employeeEntity.getDepartment());
		paySlipEntity.setDesignation(employeeEntity.getDesignation());
		paySlipEntity.setDateOfBirth(employeeEntity.getDateOfBirth());
		paySlipEntity.setDateOfJoining(employeeEntity.getDateOfJoining());
		paySlipEntity.setGender(employeeEntity.getGender());
		paySlipEntity.setBankAccNum(employeeEntity.getBankAccNum());
		paySlipEntity.setPhoneNum(employeeEntity.getPhoneNum());
		paySlipEntity.setEmailId(employeeEntity.getEmailId());

		paySlipEntity.setBasicSalary(employeeEntity.getEmployeeCtc().getBasicSalary());
		paySlipEntity.setSpecialAllowance(employeeEntity.getEmployeeCtc().getSpecialAllowance());
		paySlipEntity.setHRA(employeeEntity.getEmployeeCtc().getHRA());
		paySlipEntity.setLTA(employeeEntity.getEmployeeCtc().getLTA());
		paySlipEntity.setFoodCoupon(employeeEntity.getEmployeeCtc().getFoodCoupon());
		paySlipEntity.setProvidentFund(employeeEntity.getEmployeeCtc().getPF());
		paySlipEntity.setMonth(month);
		paySlipEntity.setYear(year);

		paySlipEntity.setLOPDays(attendanceEntity.getLOPDays());

		if (month.equals("JANUARY"))
			paySlipEntity.setNumOfDaysInGivenMonth(31);
		else if (month.equals("FEBRUARY")) {
			if (Year.of(year).isLeap())
				paySlipEntity.setNumOfDaysInGivenMonth(29);
			else
				paySlipEntity.setNumOfDaysInGivenMonth(28);
		} else if (month.equals("MARCH"))
			paySlipEntity.setNumOfDaysInGivenMonth(31);
		else if (month.equals("APRIL"))
			paySlipEntity.setNumOfDaysInGivenMonth(30);
		else if (month.equals("MAY"))
			paySlipEntity.setNumOfDaysInGivenMonth(31);
		else if (month.equals("JUNE"))
			paySlipEntity.setNumOfDaysInGivenMonth(30);
		else if (month.equals("JULY"))
			paySlipEntity.setNumOfDaysInGivenMonth(31);
		else if (month.equals("AUGUST"))
			paySlipEntity.setNumOfDaysInGivenMonth(31);
		else if (month.equals("SEPTEMBER"))
			paySlipEntity.setNumOfDaysInGivenMonth(30);
		else if (month.equals("OCTOBER"))
			paySlipEntity.setNumOfDaysInGivenMonth(31);
		else if (month.equals("NOVEMBER"))
			paySlipEntity.setNumOfDaysInGivenMonth(30);
		else if (month.equals("DECEMBER"))
			paySlipEntity.setNumOfDaysInGivenMonth(31);

		paySlipEntity.setNetDaysWorked(paySlipEntity.getNumOfDaysInGivenMonth() - paySlipEntity.getLOPDays());

		paySlipEntity.setTotalEarnings(paySlipEntity.getBasicSalary() + paySlipEntity.getSpecialAllowance()
				+ paySlipEntity.getHRA() + paySlipEntity.getLTA() + paySlipEntity.getFoodCoupon());

		// logic for professional tax

//		if(paySlipEntity.getDateOfJoining().getYear() == year)
//		{
//			if(paySlipEntity.getDateOfJoining().getMonthValue()<4)
//			{
//				paySlipEntity.setProfessionalTax(ProfessionTaxPerYear/(4-paySlipEntity.getDateOfJoining().getMonthValue()));
//			}
//		}
		paySlipEntity.setProfessionalTax(0D);

		double fraction = (double) (paySlipEntity.getLOPDays()) / (paySlipEntity.getNumOfDaysInGivenMonth());
		// formating the double to have desired number of decimal values.
		DecimalFormat df = new DecimalFormat("#.###");
		fraction = Double.valueOf(df.format(fraction));
		// System.out.println(fraction);
		paySlipEntity.setDeductionsDueToLOP(paySlipEntity.getTotalEarnings() * fraction);

		paySlipEntity.setTotalDeductions(paySlipEntity.getProvidentFund() + paySlipEntity.getProfessionalTax()
				+ paySlipEntity.getDeductionsDueToLOP());

		paySlipEntity.setNetPay(paySlipEntity.getTotalEarnings() - paySlipEntity.getTotalDeductions());

		return paySlipEntity;
	}

	public void generatePaySlip(PaySlipEntity paySlip) {

		paySlipDao.addPaySlipRecord(paySlip);

	}

	public PaySlipEntity getPaySlipRecord(Long employeeId, String month, Integer year) {
		return paySlipDao.getPaySlipRecord(employeeId, month, year);
	}

}
