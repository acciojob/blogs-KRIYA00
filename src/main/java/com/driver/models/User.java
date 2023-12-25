package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String username;
    String password;
    String firstName;
    String lastName;
    @OneToMany(mappedBy = "user",cascade =  CascadeType.ALL)

    List<Blog> blogs=new ArrayList<>();

    public List<Blog> getBlogList() {
        return blogs;
    }

    public void setBlogList(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public User(String username, String password) {

        this.username = username;
        this.password = password;
        this.firstName = "test";
        this.lastName = "test";
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}