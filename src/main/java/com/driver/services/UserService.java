package com.driver.services;

import com.driver.dtoResponse.UserResponse;
import com.driver.exceptions.UserNotFoundException;
import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository3;

    public UserResponse createUser(String username, String password)
    {
        User user=new User(username,password);
    User savedUser=userRepository3.save(user);

    UserResponse userResponse=new UserResponse();
    userResponse.setFirstName(savedUser.getFirstName());
    userResponse.setLastName(savedUser.getLastName());
    userResponse.setUsername(savedUser.getUsername());
    userResponse.setMessage("User registered sucessfully!!!");
    return userResponse;
    }

    public void deleteUser(int userId){

        userRepository3.deleteById(userId);
    }

    public User updateUser(Integer id, String password)
    {
        Optional<User> userOptional=userRepository3.findById(id);
        if(userOptional.isEmpty())
            throw new UserNotFoundException("User with given id not present !!");
        else {
            User user=userOptional.get();
            user.setPassword(password);
            userRepository3.save(user);
            return user ;
        }

    }
}
