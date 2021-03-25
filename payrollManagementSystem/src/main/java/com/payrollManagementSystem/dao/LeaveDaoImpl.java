package com.payrollManagementSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.payrollManagementSystem.entity.LeaveData;
import com.payrollManagementSystem.util.HibernateUtil;

@Repository
public class LeaveDaoImpl implements LeaveDao {

	public void addLeaveRecord(LeaveData leaveData) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(leaveData);
		session.getTransaction().commit();
		session.close();
	}

	public List<LeaveData> getLeaveDataById(Long employeeId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<LeaveData> list = session.createQuery("FROM LeaveData LD WHERE LD.employeeId= :param")
				.setParameter("param", employeeId).list();
		session.close();
		if(list.isEmpty())
			return null;
		return list;
	}

}
