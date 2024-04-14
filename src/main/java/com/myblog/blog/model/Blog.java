package com.myblog.blog.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Long id;
    
    @Column(name = "title", length = 45)
    private String title;


    @Column(name = "body", length = 100)
    private String body;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "blog_tags",
               joinColumns = @JoinColumn(name = "blog_id"),
               inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

    // Constructors
    public Blog() {
    }

    public Blog(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
 
}