package com.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dto.Course;
import com.dto.CourseType;
import com.dto.SkillLevel;
import com.dto.Topic;
import com.util.HibernateUtil;

/*
 * included HQL example
 * CURD operations for one-to-many
 */
public class CourseTopic {

	static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	static Session session = sessionFactory.openSession();
	static Transaction transaction = session.beginTransaction();

	public static void insertCourseTopics() {

		Course c = new Course("javaBeginners", "hangchen", SkillLevel.BEGINNER, "basic course", "oops",
				new BigDecimal(40.89), "strong foundations", CourseType.PAIED);
		Topic topic1 = new Topic("Building blocks", " 2 days", LocalDateTime.now(), LocalDateTime.now().plusDays(2), c);
		Topic topic2 = new Topic("introduction", " 1 days", LocalDateTime.now(), LocalDateTime.now().plusDays(1), c);
		List<Topic> topics = new ArrayList<Topic>();
		topics.add(topic1);
		topics.add(topic2);
		c.setTopics(topics);
		session.save(c);
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

	public static void getCouserData() {

		String hql = "select c.name,t.name,t.duration from Course c "
				+ "join Topic t on c.courseId = t.course.courseId where c.courseId=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, 14L);
		List<Object[]> data = query.getResultList();
		for (Object[] ob : data) {
			System.out.println(ob[0]);
			System.out.println(ob[1]);
			System.out.println(ob[2]);
		}
		session.close();
		sessionFactory.close();

	}

	public static void updateCourseTopics() {

		Course c = session.load(Course.class, 14l);
		c.setAuthor("CooperNew");
		session.update(c);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public static void deleteCourseTopics() {

		Course c = session.load(Course.class, 14l);
		session.delete(c);
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
