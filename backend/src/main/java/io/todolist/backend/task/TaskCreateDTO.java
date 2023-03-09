package io.todolist.backend.task;

import javax.validation.constraints.NotBlank;

public class TaskCreateDTO {
	@NotBlank
	private String taskName;
	
	
	private String taskDesc;
	
	@NotBlank
	private String priority;
	
	public TaskCreateDTO() {}
	
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

	public TaskCreateDTO(String taskName, String taskDesc, String priority) {
		this.taskName = taskName;
		this.taskDesc = taskDesc;
		this.priority = priority;
	}
}
