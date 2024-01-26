package com.example.qlpost.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.thymeleaf.expression.Strings;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String title;
    private int likes;
    private String status;
    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(Long id, String content, String title, int likes, String status, User user) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.likes = likes;
        this.status = status;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
