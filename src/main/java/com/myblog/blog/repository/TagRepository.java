package com.myblog.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myblog.blog.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("SELECT t FROM Tag t WHERE t.tagName = :tagName")
    Tag findTagByTagName(String tagName);

    @Query("SELECT t FROM Tag t WHERE t.parentTag = :parenTag")
    List<Tag> findChildTagsByParentTagID(Tag parenTag);
}
    