package com.ankur.SpringSecEx.service;

import com.ankur.SpringSecEx.model.UserPrincipal;
import com.ankur.SpringSecEx.model.Users;
import com.ankur.SpringSecEx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user1 = userRepo.findByUsername(username);
        if(user1 == null){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User not found!!");
        }
        return new UserPrincipal(user1);
    }
}
