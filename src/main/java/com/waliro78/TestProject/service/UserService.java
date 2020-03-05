package com.waliro78.TestProject.service;

import com.waliro78.TestProject.entity.User;
import com.waliro78.TestProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 3/2/2020.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createANewUser(User user){
       return userRepository.save(user);
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public User findById(Integer userId) {
        return userRepository.getOne(userId);
    }
    public boolean isExists(Integer userId){
        return userRepository.existsById(userId);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
