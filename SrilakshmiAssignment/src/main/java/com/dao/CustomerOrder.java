package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dto.Customer;
import com.dto.Gender;
import com.dto.Orders;
import com.util.HibernateUtil;
/*
 * CURD operations for one-to-many
 */
public class CustomerOrder {

	static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	static Session session = sessionFactory.openSession();
	static Transaction transaction = session.beginTransaction();

	public static void insertCustomerOrders() {

		Customer c = new Customer("sri", "gari", Gender.Female);
		Orders o1 = new Orders("mobile", c);
		Orders o2 = new Orders("laptop", c);
		List<Orders> orders = new ArrayList<Orders>();
		orders.add(o1);
		orders.add(o2);
		c.setOrders(orders);
		session.save(c);
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

	public static Customer getCustomerOrders() {

		Customer c = session.get(Customer.class, 1);
		transaction.commit();
		session.close();
		sessionFactory.close();
		return c;
	}

	public static void updateCustomerUsers() {

		Customer c = session.load(Customer.class, 1);
		c.setFirstName("updateNew");
		session.update(c);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public static void deleteCustomerUsers() {

		Customer c = session.load(Customer.class, 2);
		session.delete(c);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
