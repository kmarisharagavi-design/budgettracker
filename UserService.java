package com.risha.budgettracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risha.budgettracker.model.User;
import com.risha.budgettracker.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User register(User user){
        return repo.save(user);
    }

    public User login(String email,String password){
        return repo.findByEmailAndPassword(email,password);
    }
}