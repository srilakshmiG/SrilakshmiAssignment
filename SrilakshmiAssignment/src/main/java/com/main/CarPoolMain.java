package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.singleTable.Scoop;
import com.singleTable.Waze;
import com.util.HibernateUtil;
/*
 * SingleTable 
 */
public class CarPoolMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Scoop s = new Scoop("GrapeWine", "valleyView", 20.0, true, "John");
		Waze w = new Waze("abc", "abc", 14.0, "NON-AC", "Good");
		session.save(s);
		session.save(w);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
