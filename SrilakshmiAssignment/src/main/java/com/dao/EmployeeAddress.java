package com.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.dto.Address;
import com.dto.Employee;
import com.dto.Gender;
import com.util.HibernateUtil;

/*
 * CURD operations for one-to-one
 * Criteria API
 * Named Queries
 */
public class EmployeeAddress {

	public static List<Employee> getEmployeeData() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> employees = new ArrayList<Employee>();
		Employee emp = session.get(Employee.class, 2);
		employees.add(emp);
		transaction.commit();
		session.close();
		sessionFactory.close();
		return employees;

	}

	public static void getEmployeeDataByFirstLetter(String name) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.like("name", name));
		List<Employee> employees = criteria.list();
		System.out.println(employees.size());
		session.close();
		sessionFactory.close();

	}

	public static void getEmployeeDataByName(String name) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query hql = session.createNamedQuery("employeeByName");
		hql.setParameter(1, name);
		List<Employee> employees = hql.getResultList();
		System.out.println(employees.size());
		session.close();
		sessionFactory.close();
	}

	public static void insertEmployeeAddress() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee e = new Employee("sri", LocalDate.now(), Gender.Female);
		Address a = new Address("harrison", "kansas", "MO", "USA", "2345");
		e.setAddress(a);
		a.setEmployee(e);
		session.save(e);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public static void updateEmployee() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee emp = session.get(Employee.class, 2);
		emp.setName("srilakshmiUpdate");
		session.update(emp);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public static void deleteEmployee() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee emp = session.get(Employee.class, 1);
		session.delete(emp);
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
