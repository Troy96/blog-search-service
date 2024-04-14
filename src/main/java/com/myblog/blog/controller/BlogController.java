package com.myblog.blog.controller;

import com.myblog.blog.model.Blog;
import com.myblog.blog.service.BlogService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {
   private final BlogService blogService;

   public BlogController(BlogService blogService) {
      this.blogService = blogService;
   }

   @GetMapping("/blogs/search")
   public List<Blog> searchBlogsByTagName(@RequestParam("tag") String tagName) {

      List<Blog> blogs = blogService.getBlogsByTagName(tagName);
      return blogs;
   }

}
