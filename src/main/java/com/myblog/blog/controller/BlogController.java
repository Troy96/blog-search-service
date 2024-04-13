package com.myblog.blog.controller;

import com.myblog.blog.model.Blog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class BlogController {
     @GetMapping("/sample") 
     public Blog getSample() {
        return new Blog("Hello Spring!!!");
     } 
}

