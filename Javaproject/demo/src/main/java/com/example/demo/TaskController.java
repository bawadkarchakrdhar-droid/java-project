package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List; // Iske bina 'List' red rahega

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return repository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        repository.deleteById(id);
    }
}