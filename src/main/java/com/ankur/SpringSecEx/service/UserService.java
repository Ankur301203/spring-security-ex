package com.ankur.SpringSecEx.service;

import com.ankur.SpringSecEx.model.Users;
import com.ankur.SpringSecEx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public Users register(Users user){
        return userRepo.save(user);

    }
}
