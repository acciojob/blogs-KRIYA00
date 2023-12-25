package com.driver.models;

import javax.persistence.*;
import java.util.*;
@Entity
public class Image
{
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String description;
    String dimensions;

    public Image() {
    }

    public Blog getBlog() {

        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @ManyToOne
    @JoinColumn
    Blog blog;
    public Image( String description, String dimensions) {

        this.description = description;
        this.dimensions = dimensions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}