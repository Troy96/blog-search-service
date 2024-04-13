package com.myblog.blog.model;


public class Blog {
    private String message;

    public Blog() {
    }

    public Blog(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}