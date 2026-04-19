package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task {
    @Id
    private String id;
    private String title;
    private boolean completed;
    private String dateDay; // Nayi line: Date aur Day ke liye

    // Default Constructor (MongoDB ke liye zaroori hai)
    public Task() {}

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public String getDateDay() { return dateDay; } // Nayi line
    public void setDateDay(String dateDay) { this.dateDay = dateDay; } // Nayi line
}