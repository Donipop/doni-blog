package com.doni.blog.service;

import com.doni.blog.model.User;
import com.doni.blog.model.UserRole;
import com.doni.blog.repository.MemoryUserRepository;
import com.doni.blog.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository = new MemoryUserRepository();

    public void signUp(User user){
        user.setUserRole(UserRole.User);
        userRepository.save(user);
    }
}
