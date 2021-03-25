package com.payrollManagementSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.payrollManagementSystem.entity.AttendanceEntity;
import com.payrollManagementSystem.util.HibernateUtil;

@Repository
public class AttendanceDaoImpl implements AttendanceDao {

	public void addAttendanceEntry(AttendanceEntity AttendanceEntity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(AttendanceEntity);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public AttendanceEntity getAttendanceEntityOfGivenMonthAndYearById(Long employeeId, String month, Integer year) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<AttendanceEntity> list = session
				.createQuery("FROM AttendanceEntity AE WHERE AE.employeeId=:param AND "
						+ "AE.month=:param2 AND AE.year=:param3")
				.setParameter("param", employeeId).setParameter("param2", month).setParameter("param3", year).list();
		session.getTransaction().commit();
		session.close();
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

}
