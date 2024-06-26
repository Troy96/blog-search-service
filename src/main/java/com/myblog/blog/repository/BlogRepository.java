package com.myblog.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myblog.blog.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query("SELECT DISTINCT b FROM Blog b JOIN b.tags t WHERE t.tagName = :tagName OR t.parentTag = :tagName")

    List<Blog> findByTagName(String tagName);

    @Query("SELECT DISTINCT b FROM Blog b JOIN b.tags t WHERE t.id IN :tagIds")

    List<Blog> findBlogsByTagIDs(List<Long> tagIds);
}
