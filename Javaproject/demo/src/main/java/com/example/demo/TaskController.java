package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*") // Frontend connect karne ke liye zaroori hai
public class TaskController {

    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    // Saare tasks dekhne ke liye
    @GetMapping
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    // Naya task add karne ke liye
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return repository.save(task);
    }

    // Task delete karne ke liye
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        repository.deleteById(id);
    }
}