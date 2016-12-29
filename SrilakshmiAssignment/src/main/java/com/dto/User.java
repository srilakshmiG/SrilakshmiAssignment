package com.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotBlank;
/*
 * Hibernate Validator
 */
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	@NotBlank(message = "first name can not be blank")
	private String firstName;
	@NotBlank(message = "last name can not be blank")
	private String lastName;
	private String middleName;
	@Column(name = "pwd")
	private String password;
	private LocalDate DOB;
	private LocalDateTime createdTime;
	private LocalDateTime updatedTime;
	@ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
	private List<Course> courses;

	public User() {
		super();
	}

	public User(String firstName, String lastName, String middleName, String password, LocalDate dOB,
			LocalDateTime createdTime, LocalDateTime updatedTime) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.password = password;
		DOB = dOB;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
	}

	public User(String firstName, String lastName, String middleName, String password, LocalDate dOB,
			LocalDateTime createdTime, LocalDateTime updatedTime, List<Course> courses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.password = password;
		DOB = dOB;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
		this.courses = courses;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", password=" + password + ", DOB=" + DOB + ", createdTime=" + createdTime
				+ ", updatedTime=" + updatedTime + "]";
	}

}
