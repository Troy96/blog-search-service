package com.myblog.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myblog.blog.model.Tag;
import com.myblog.blog.repository.TagRepository;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag getTagByTagName(String tagName) {
        return tagRepository.findTagByTagName(tagName);
    }

    public List<Long> getTagIds(List<Tag> tags) {
        List<Long> tagIds = new ArrayList<>();
        for (Tag tag : tags) {
            tagIds.add(tag.getTagId());
        }
        return tagIds;
    }

    public List<Tag> getChildTagsByTagID(Tag tag) {
        List<Tag> response = new ArrayList<>();

        /**
         * Add the current tag to the list
         */
        response.add(tag);

        /**
         * Fetch the immediate child tags
         */
        List<Tag> childTags = tagRepository.findChildTagsByParentTagID(tag);

        /**
         * Iterate and recursively add the children of the current tag
         */
        for (Tag childTag : childTags) {
            response.addAll(getChildTagsByTagID(childTag));
        }

        /**
         * Return the response
         */
        return response;
    }

}