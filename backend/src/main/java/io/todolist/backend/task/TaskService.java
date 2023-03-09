package io.todolist.backend.task;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TaskService {
	@Autowired
	private TaskRepository repository;
	
	public Task create(TaskCreateDTO data) {
		Task newTask = new Task(data.getTaskName(), data.getTaskDesc(), data.getPriority());
		this.repository.save(newTask);
		return newTask;
	}
	
	public List<Task> getAll() {
		return this.repository.findAll();
	}
	
	public Optional<Task> getById(Long id) {
		return this.repository.findById(id);
	}
	
	public boolean delete(Long id) {
		Optional<Task> maybeTask = this.getById(id);
		if (maybeTask.isEmpty()) {
			return false;
		}
		this.repository.delete(maybeTask.get());
		return true;
	}
	
	public Task update(Long taskId, TaskUpdateDTO data, Task task) {
		task.setTaskName(data.taskName);
		task.setTaskDesc(data.taskDesc);
		task.setPriority(data.priority);
		return this.repository.save(task);
	}
}
