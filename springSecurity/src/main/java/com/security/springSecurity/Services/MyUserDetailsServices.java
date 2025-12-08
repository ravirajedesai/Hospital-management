package com.security.springSecurity.Services;

import com.security.springSecurity.Dao.UserRepo;
import com.security.springSecurity.Model.User;
import com.security.springSecurity.Model.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsServices implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=repo.findByUsername(username);
        if (user==null){
            System.out.println("Error 404");
            throw new UsernameNotFoundException("error 404");
        }
        return new UserPrinciple(user);
    }
}
