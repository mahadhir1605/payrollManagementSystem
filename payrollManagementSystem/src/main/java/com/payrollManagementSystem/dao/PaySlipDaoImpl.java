package com.payrollManagementSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.payrollManagementSystem.util.HibernateUtil;
import com.payrollManagementSystem.entity.PaySlipEntity;

@Repository
public class PaySlipDaoImpl implements PaySlipDao {

	public void addPaySlipRecord(PaySlipEntity paySlipEntity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(paySlipEntity);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public PaySlipEntity getPaySlipRecord(Long employeeId, String month, Integer year) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<PaySlipEntity> list = session
				.createQuery(
						"FROM PaySlipEntity P WHERE " + "P.employeeId=:param1 AND P.month=:param2 AND P.year=:param3")
				.setParameter("param1", employeeId).setParameter("param2", month).setParameter("param3", year).list();
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

}
