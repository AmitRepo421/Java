package com.techlabs.project.service;

import org.springframework.stereotype.Service;

import com.techlabs.project.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository; 

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}