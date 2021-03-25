package com.payrollManagementSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.payrollManagementSystem.entity.Otp;
import com.payrollManagementSystem.util.HibernateUtil;

@Repository
public class OtpDaoImpl implements OtpDao {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public void addOtpEntry(Otp otp) {
		System.out.println("inside addOtpEntry()");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(otp);
		session.getTransaction().commit();
		session.close();
		System.out.println("Otp added\n" + otp);
//		sessionFactory.getCurrentSession().saveOrUpdate(otp);
	}

	public Otp getMappedOtp(int employeeId) {
		System.out.println("inside getMappedOtp()");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
//		Otp otp = session.load(Otp.class, employeeId);
		Otp otp = session.get(Otp.class, employeeId);
		session.close();
//		Otp otp = sessionFactory.getCurrentSession().load(Otp.class, employeeId);
		return otp;
	}

	@SuppressWarnings("unchecked")
	public boolean validateOtp(Otp otp) {
		System.out.println("inside validateOtp()");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Otp> otpList = session
				.createQuery(
						"from Otp as O where O.employeeId = " + otp.getEmployeeId() + " AND O.otp = " + otp.getOtp())
				.list();

		if (otpList.size() == 0) {
			session.close();
			return false;
		} else if (getMappedOtp(otp.getEmployeeId()).getOtp() == otpList.get(0).getOtp()) {
			session.close();
			return true;
		}
		session.close();
		return false;
	}
}
