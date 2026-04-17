package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*") // Ye sabse important line hai connection ke liye
public class TaskController {

    @Autowired
    private TaskRepository repository;

    // Saare tasks lene ke liye
    @GetMapping
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    // Naya task save karne ke liye
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return repository.save(task);
    }

    // Task delete karne ke liye
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        repository.deleteById(id);
    }
}