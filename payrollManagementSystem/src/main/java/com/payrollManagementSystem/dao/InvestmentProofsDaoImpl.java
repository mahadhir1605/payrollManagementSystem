package com.payrollManagementSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.payrollManagementSystem.entity.InvestmentProofs;
import com.payrollManagementSystem.util.HibernateUtil;

@Repository
public class InvestmentProofsDaoImpl implements InvestmentProofsDao {

	public void addEntry(InvestmentProofs investmentProofs) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(investmentProofs);
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	public List<InvestmentProofs> getRecordListByIdAndFinancialYear(Long employeeId, String financialYear) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<InvestmentProofs> list = session
				.createQuery("FROM InvestmentProofs IP WHERE IP.employeeid=:param1 " + "AND IP.financialYear=:param2")
				.setParameter("param1", employeeId).setParameter("param2", financialYear).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public void setStatusApproved(Long employeeId, String financialYear) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		List<InvestmentProofs> list = getRecordListByIdAndFinancialYear(employeeId, financialYear);
		InvestmentProofs investmentProofs = session.get(InvestmentProofs.class,
				list.get(list.size() - 1).getRecordId());
		investmentProofs.setStatus("APPROVED");
		session.getTransaction().commit();
		session.close();
	}

	public void setStatusRejected(Long employeeId, String financialYear) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<InvestmentProofs> list = getRecordListByIdAndFinancialYear(employeeId, financialYear);
		InvestmentProofs investmentProofs = session.get(InvestmentProofs.class,
				list.get(list.size() - 1).getRecordId());
		investmentProofs.setStatus("REJECTED");
		session.getTransaction().commit();
		session.close();

	}

}
