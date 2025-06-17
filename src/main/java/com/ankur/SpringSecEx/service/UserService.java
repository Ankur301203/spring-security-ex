package com.ankur.SpringSecEx.service;

import com.ankur.SpringSecEx.model.Users;
import com.ankur.SpringSecEx.repo.UserRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);

    }

    public Users getUser(String id) {
        return userRepo.findById(Integer.parseInt(id)).orElse(null);
    }

    public String verify(Users user) {
        Authentication authentication =
                authManager.authenticate(new
                        UsernamePasswordAuthenticationToken(
                                user.getUsername(),
                                user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }
        return "fail!!";
    }
}
