package io.todolist.backend.task;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CreationTimestamp
	private Date dateCreated;
	
	@Column
	private String taskName;
	
	@Column
	private String taskDesc;
	
	@Column
	private String priority;
	
	
	public Task() {
		
	}
	
	public Task(String taskName, String taskDesc, String priority) {
		this.taskName = taskName;
		this.taskDesc = taskDesc;
		this.priority = priority;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Long getId() {
		return id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
}