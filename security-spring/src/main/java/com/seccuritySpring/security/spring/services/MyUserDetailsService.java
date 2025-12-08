package com.seccuritySpring.security.spring.services;

import com.seccuritySpring.security.spring.entity.User;
import com.seccuritySpring.security.spring.repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private userRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=repo.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("User Not Found");
        }

        return null;
    }
}
