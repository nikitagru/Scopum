package com.example.scopum.service;

import com.example.scopum.model.User;
import com.example.scopum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepo;

    public UserService(UserRepository userRepository) {
        this.userRepo = userRepository;
    }


    public User findByChatId(long id) {
        return userRepo.findById(id);
    }


    public void addUser(User user) {
        userRepo.save(user);
    }

    public void updateUser(User user) {
        userRepo.save(user);
    }
}
