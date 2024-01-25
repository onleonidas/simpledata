package com.lucasangelo.todosimple.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = Task.TABLE_NAME)
public class Task {
    
    public static final String TABLE_NAME = "task";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "title_task", nullable = false, length = 100)
    @Size(min = 5, max = 100)
    private String title_task;

    @Column(name = "description", nullable = false, length = 255)
    @Size(min = 5, max = 255)
    @NotBlank
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    public Task() {

    }

    public Task(Long user, String title_task, String description) {
        this.id = user;
        this.title_task = title_task;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long user) {
        this.id = user;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return this.title_task;
    }

    public void setTitle(String title_task) {
        this.title_task = title_task;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task id(Long id){
        setId(id);
        return this;
    }

    public Task descriptionTask(String description) {
        setDescription(description);
        return this;
    }

    public Task user(User user) {
        setUser(user);
        return this;
    }

}
