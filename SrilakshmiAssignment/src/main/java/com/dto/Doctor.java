package com.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctorId;
	private String name;
	private String department;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "doctor_patient", joinColumns = @JoinColumn(name = "doctorId", referencedColumnName = "doctorId"), inverseJoinColumns = @JoinColumn(name = "patientId", referencedColumnName = "patientId"))
	private List<Patient> patients;

	public Doctor() {

	}

	public Doctor(String name, String department) {
		super();
		this.name = name;
		this.department = department;
	}

	public Doctor(int doctorId, String name, String department, List<Patient> patients) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.department = department;
		this.patients = patients;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", name=" + name + ", department=" + department + ", patients="
				+ patients + "]";
	}

}
