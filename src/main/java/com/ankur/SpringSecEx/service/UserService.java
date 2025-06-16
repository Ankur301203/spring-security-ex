package com.ankur.SpringSecEx.service;

import com.ankur.SpringSecEx.model.Users;
import com.ankur.SpringSecEx.repo.UserRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);

    }

    public Users getUser(String id) {
        return userRepo.findById(Integer.parseInt(id)).orElse(null);
    }
}
