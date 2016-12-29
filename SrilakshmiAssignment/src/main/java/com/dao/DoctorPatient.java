package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dto.Doctor;
import com.dto.Gender;
import com.dto.Patient;
import com.util.HibernateUtil;
/*
 * CURD operations for many-to-many
 */
public class DoctorPatient {

	static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	static Session session = sessionFactory.openSession();
	static Transaction transaction = session.beginTransaction();

	public static void insertDoctorPatient() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Doctor d1 = new Doctor();
		d1.setDepartment("general");
		List<Patient> patients = new ArrayList<Patient>();
		Patient patient1 = new Patient("kavya", Gender.Female, "headache");
		Patient patient2 = new Patient("divya", Gender.Female, "headache");
		patients.add(patient2);
		patients.add(patient1);
		d1.setPatients(patients);
		try {
			session.save(d1);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	public static List<Doctor> getDoctorPatientData() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Doctor> doctors = new ArrayList<Doctor>();
		Doctor doctor = session.get(Doctor.class, 3);
		doctors.add(doctor);
		transaction.commit();
		session.close();
		sessionFactory.close();
		return doctors;

	}

	public static void updateDoctorPatient() {

		Doctor doctor = session.get(Doctor.class, 3);
		doctor.setDepartment("updated");
		session.update(doctor);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public static void deleteDoctorPatient() {

		Doctor doctor = session.get(Doctor.class, 3);
		Patient p = session.get(Patient.class, 5);
		doctor.getPatients().remove(p);
		session.save(doctor);
		session.delete(p);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
