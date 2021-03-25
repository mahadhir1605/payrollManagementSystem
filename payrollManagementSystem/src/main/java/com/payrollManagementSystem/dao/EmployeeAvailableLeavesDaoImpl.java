package com.payrollManagementSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.payrollManagementSystem.entity.EmployeeAvailableLeaves;
import com.payrollManagementSystem.util.HibernateUtil;

@Repository
public class EmployeeAvailableLeavesDaoImpl implements EmployeeAvailableLeavesDao{

	@Override
	public void addEntry(Long employeeId) {
		EmployeeAvailableLeaves employeeAvailableLeaves = new EmployeeAvailableLeaves();
		employeeAvailableLeaves.setEmployeeId(employeeId);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(employeeAvailableLeaves);
		session.getTransaction().commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public EmployeeAvailableLeaves getDataById(Long employeeId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<EmployeeAvailableLeaves> list = session.createQuery
				("FROM EmployeeAvailableLeaves E WHERE E.employeeId = :param")
				.setParameter("param", employeeId).list();
		//System.out.println(list);
		session.getTransaction().commit();
		session.close();
		return list.get(0);
	}

	@Override
	public void updateEntry(EmployeeAvailableLeaves employeeAvailableLeaves) {
		System.out.println(employeeAvailableLeaves);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		EmployeeAvailableLeaves employeeAvailableLeaves2 = 
				session.get(EmployeeAvailableLeaves.class, employeeAvailableLeaves.getRecordId());
		employeeAvailableLeaves2.setEarnedLeaves(employeeAvailableLeaves.getEarnedLeaves());
		employeeAvailableLeaves2.setSickLeaves(employeeAvailableLeaves.getSickLeaves());
		employeeAvailableLeaves2.setEmergencyLeaves(employeeAvailableLeaves.getEmergencyLeaves());
		session.getTransaction().commit();
		session.close();
		
	}
	
	

}
