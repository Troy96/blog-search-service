package com.myblog.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    @Column(name = "tag_name")
    private String tagName;

    @ManyToOne
    @JoinColumn(name = "parent_tag_id")
    private Tag parentTag;


    public Long getTagId() {
        return id;
    }

    public String getTagName() {
        return tagName;
    }

    public Tag getParentTag() {
        return parentTag;
    }
}
