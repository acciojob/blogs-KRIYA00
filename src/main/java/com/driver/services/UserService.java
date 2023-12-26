package com.driver.services;

import com.driver.dtoResponse.UserResponse;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository3;

    public User createUser(String username, String password)
    {
       // User user=new User(username,password);
   /* User savedUser=userRepository3.save(user);


    UserResponse userResponse=new UserResponse();
    userResponse.setFirstName(savedUser.getFirstName());
    userResponse.setLastName(savedUser.getLastName());
    userResponse.setUsername(savedUser.getUsername());
    userResponse.setMessage("User registered sucessfully!!!");
    return userResponse;
    */
        User user = new User();
        user.setFirstName("test");
        user.setLastName("test");
        user.setUsername(username);
        user.setPassword(password);

        return userRepository3.save(user);
    }

    public void deleteUser(int userId){

        userRepository3.deleteById(userId);
    }

    public User updateUser(Integer id, String password)
    {
        User user=userRepository3.findById(id).get();

            user.setPassword(password);
            userRepository3.save(user);
            return user ;


    }
}
