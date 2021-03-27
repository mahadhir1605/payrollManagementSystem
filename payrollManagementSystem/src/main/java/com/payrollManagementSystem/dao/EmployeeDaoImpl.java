package com.payrollManagementSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.payrollManagementSystem.entity.Employee;
import com.payrollManagementSystem.entity.Login;
import com.payrollManagementSystem.util.HibernateUtil;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

//	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	@SuppressWarnings("unchecked")
	@Override
	public boolean validateEmployee(Login login) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Employee> employeeList = session
				.createQuery("from Employee as E where E.employeeId = :employeeId "
						+ "AND E.password = :password AND E.usertype = :usertype")
				.setParameter("employeeId", login.getEmployeeId()).setParameter("password", login.getPassword())
				.setParameter("usertype", login.getUserType()).list();
		session.getTransaction().commit();
		session.close();
//		System.out.println(login.getEmployeeId());
//		System.out.println(employeeList.get(0).getEmployeeId());
		if (employeeList.isEmpty())
			return false;
		else if (login.getEmployeeId() == employeeList.get(0).getEmployeeId())
			return true;
		return false;
	}

	@Override
	public void addEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(employee);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Employee> employeeList = session.createQuery("from Employee").list();
		session.close();
		return employeeList;
	}

	@Override
	public void deleteEmployee(long employeeId) {
		System.err.println("inside deleteEmployee -- \n" + employeeId);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee employee = session.load(Employee.class, employeeId);
		System.err.println(employee);
		if (null != employee)
			session.delete(employee);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Employee getEmployee(long employeeId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class, employeeId);
		session.close();
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		System.err.println(employee.getPhoneNum());
		System.err.println(employee.getEmailId());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.createQuery(
				"update Employee E set E.phoneNum = :newPhoneNum, E.emailId = :newEmailId where E.employeeId = :employeeId")
				.setParameter("newPhoneNum", employee.getPhoneNum()).setParameter("newEmailId", employee.getEmailId())
				.setParameter("employeeId", employee.getEmployeeId()).executeUpdate();
		session.getTransaction().commit();
		session.close();
		return employee;
	}

	@Override
	public void updatePassword(Employee employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.createQuery("update Employee set password = :newPassword where employeeId = :employeeId")
				.setParameter("newPassword", employee.getPassword())
				.setParameter("employeeId", employee.getEmployeeId()).executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateEmployeeAllDetails(Employee employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(employee);
		session.getTransaction().commit();
		session.close();
	}



}
