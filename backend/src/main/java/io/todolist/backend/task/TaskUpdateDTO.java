package io.todolist.backend.task;

import javax.validation.constraints.NotBlank;



public class TaskUpdateDTO {
	@NotBlank
	String taskName;
	
	
	String taskDesc;
	
	@NotBlank
	String priority;
	
	public TaskUpdateDTO() {}
	
	public TaskUpdateDTO(String taskName, String taskDesc, String priority) {
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
}
