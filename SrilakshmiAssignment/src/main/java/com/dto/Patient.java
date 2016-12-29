package com.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	private String name;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String symptoms;
	@ManyToMany(mappedBy = "patients", fetch = FetchType.EAGER)
	private List<Doctor> doctors;

	public Patient(int patientId, String name, Gender gender, String symptoms, List<Doctor> doctors) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.gender = gender;
		this.symptoms = symptoms;
		this.doctors = doctors;
	}

	public Patient(String name, Gender gender, String symptoms) {
		super();
		this.name = name;
		this.gender = gender;
		this.symptoms = symptoms;
	}

	public Patient() {

	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name + ", gender=" + gender + ", symptoms=" + symptoms
				+ "]";
	}

}
