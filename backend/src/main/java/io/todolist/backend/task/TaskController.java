package io.todolist.backend.task;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
@RequestMapping("/tasks")
public class TaskController {
	Logger logger = LoggerFactory.getLogger(TaskController.class);
	
	@Autowired
	private TaskService service;
	
	@GetMapping
	public ResponseEntity<List<Task>> getAll() {
		List<Task> allEmployees = this.service.getAll();
		logger.info("Task retrieved successfully");
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> getById(@PathVariable Long id) {
		Optional<Task> maybeTask = this.service.getById(id);
		if (maybeTask.isEmpty()) {
			logger.error("Task was not found.");
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		logger.info("Task successfully found.");
		return new ResponseEntity<>(maybeTask.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Task> create(@RequestBody TaskCreateDTO data) {
		Task createdTask = this.service.create(data);
		return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Task> delete(@PathVariable Long id) {
		boolean isDeleted = this.service.delete(id);
		
		if (isDeleted) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id,
            @RequestBody TaskUpdateDTO data) {

        Optional<Task> maybeTask = this.service.getById(id);
        if (maybeTask.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No job found with id: " + id);
        }

        Task task = maybeTask.get();

        Task updatedEmployee = this.service.update(id, data, task);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
}
