package com.myblog.blog.controller;

import com.myblog.blog.model.Blog;
import com.myblog.blog.model.Tag;
import com.myblog.blog.service.BlogService;
import com.myblog.blog.service.TagService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {
   private final BlogService blogService;
   private final TagService tagService;

   public BlogController(BlogService blogService, TagService tagService) {
      this.blogService = blogService;
      this.tagService = tagService;
   }

   @GetMapping("/blogs/search")
   public List<Blog> searchBlogsByTagName(@RequestParam("tag") String tagName) {


      /**
       * Get the tag details by its name
       */
      Tag tag = tagService.getTagByTagName(tagName);

      // System.out.println("This is the tagID by tagName: "+ tag.getTagId());
      
      /**
       * If tag does not exist, return an empty list
       */
      if (tag == null) {
         return List.of();
      }

      /**
       * Get the children tags hierachy (recursively) includeing the current tag itself
       */
      List<Tag> childTags = tagService.getChildTagsByTagID(tag);

      // for (Tag tag2 : childTags) {
      // System.out.println("Child Tag: "+ tag2.getTagName());
      // }

      /**
       * Get the ids of the tags obtained from above
       */
      List<Long> childTagIds = tagService.getTagIds(childTags);

      /**
       * Get the blogs linked with the tag IDs from above
       */
      List<Blog> blogs = blogService.getBlogsByTagIDs(childTagIds);

      return blogs;
   }

}
