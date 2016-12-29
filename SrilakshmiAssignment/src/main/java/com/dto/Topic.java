package com.dto;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long topicId;
	private String name;
	private String duration;
	private LocalDateTime createdDateTime;
	private LocalDateTime updatedDateTime;
	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;

	public Topic() {
		super();
	}

	public Topic(String name, String duration, LocalDateTime createdDateTime, LocalDateTime updatedDateTime,
			Course course) {
		super();
		this.name = name;
		this.duration = duration;
		this.createdDateTime = createdDateTime;
		this.updatedDateTime = updatedDateTime;
		this.course = course;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", name=" + name + ", duration=" + duration + ", createdDateTime="
				+ createdDateTime + ", updatedDateTime=" + updatedDateTime + "]";
	}

}
