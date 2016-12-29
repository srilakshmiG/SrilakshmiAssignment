package com.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dto.Course;
import com.dto.CourseType;
import com.dto.SkillLevel;
import com.dto.User;
import com.util.HibernateUtil;

/*
 * CURD operations for many-to-many
 */
public class UserCourse {

	public static void insertUserCourse() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Course c1 = new Course("java", "Curtis", SkillLevel.BEGINNER, "basic course", "oops", new BigDecimal(40.89),
				"strong foundations", CourseType.PAIED);
		List<User> users = new ArrayList<User>();
		User user1 = new User("sri", "Gari", "lakshmi", "srilu", LocalDate.now(), LocalDateTime.now(),
				LocalDateTime.now());
		User user2 = new User("aaa", "a", "aaaa", "srilu", LocalDate.now(), LocalDateTime.now(), LocalDateTime.now());
		users.add(user1);
		users.add(user2);
		c1.setUsers(users);
		session.save(c1);
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

	public static List<User> getUserDate() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<User> users = new ArrayList<User>();
		User user = session.get(User.class, 5L);
		users.add(user);
		transaction.commit();
		session.close();
		sessionFactory.close();
		return users;

	}

	public static List<Course> getCouserData() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Course> courses = new ArrayList<Course>();
		Course course = session.get(Course.class, 14L);
		courses.add(course);
		transaction.commit();
		session.close();
		sessionFactory.close();
		return courses;

	}

	public static void updateUsers() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		User user = session.get(User.class, 12L);
		user.setFirstName("updatednew");
		session.update(user);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public static void deleteUsers() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Course course = session.get(Course.class, 12L);
		User user = session.get(User.class, 13L);
		course.getUsers().remove(user);
		session.save(course);
		session.delete(user);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
