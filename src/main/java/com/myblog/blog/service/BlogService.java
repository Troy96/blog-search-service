package com.myblog.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myblog.blog.model.Blog;
import com.myblog.blog.repository.BlogRepository;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> getBlogsByTagName(String tagName) {
        //System.out.println("This is tagname: "+ tagName);
        List<Blog> blogs = blogRepository.findByTagName(tagName);
        return blogs;
    }

    public List<Blog> getBlogsByTagIDs(List<Long> tagIDs) {
        //System.out.println("These are tagIDs: "+ tagIDs);
        List<Blog> blogs = blogRepository.findBlogsByTagIDs(tagIDs);
        return blogs;
    }
}
