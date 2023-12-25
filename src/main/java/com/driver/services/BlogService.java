package com.driver.services;

import com.driver.exceptions.UserNotFoundException;
import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
   private BlogRepository blogRepository1;

    @Autowired
   private UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        Blog blog=new Blog();
        blog.setTitle(title);
        blog.setContent(content);
       Optional<User> userOptional=userRepository1.findById(userId);
       if(userOptional.isEmpty())
        {
            throw  new UserNotFoundException("User with given userId not found !!");
        }
       else {

           User user=userOptional.get();
           blog.setUser(user);
           blogRepository1.save(blog);
           user.getBlogs().add(blog);
           userRepository1.save(user);
       }
       return blog;
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
       blogRepository1.deleteById(blogId);
    }
}
