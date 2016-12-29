package com.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
	private String name;
	private String author;
	@Enumerated(EnumType.STRING)
	private SkillLevel level;
	private String description;
	private String prereqs;
	private BigDecimal fee;
	private String endGoal;
	@Enumerated(EnumType.STRING)
	private CourseType type;
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Topic> topics;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_course", joinColumns = @JoinColumn(name = "courseId", referencedColumnName = "courseId"), inverseJoinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"))
	private List<User> users;

	public Course() {
		super();
	}

	public Course(String name, String author, SkillLevel level, String description, String prereqs, BigDecimal fee,
			String endGoal, CourseType type) {
		super();
		this.name = name;
		this.author = author;
		this.level = level;
		this.description = description;
		this.prereqs = prereqs;
		this.fee = fee;
		this.endGoal = endGoal;
		this.type = type;
	}

	public Course(String name, String author, SkillLevel level, String description, String prereqs, BigDecimal fee,
			String endGoal, CourseType type, List<User> users) {
		super();
		this.name = name;
		this.author = author;
		this.level = level;
		this.description = description;
		this.prereqs = prereqs;
		this.fee = fee;
		this.endGoal = endGoal;
		this.type = type;
		this.users = users;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public SkillLevel getLevel() {
		return level;
	}

	public void setLevel(SkillLevel level) {
		this.level = level;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrereqs() {
		return prereqs;
	}

	public void setPrereqs(String prereqs) {
		this.prereqs = prereqs;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public String getEndGoal() {
		return endGoal;
	}

	public void setEndGoal(String endGoal) {
		this.endGoal = endGoal;
	}

	public CourseType getType() {
		return type;
	}

	public void setType(CourseType type) {
		this.type = type;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", author=" + author + ", level=" + level
				+ ", description=" + description + ", prereqs=" + prereqs + ", fee=" + fee + ", endGoal=" + endGoal
				+ ", type=" + type + ", topics=" + topics + ", users=" + users + "]";
	}

}
