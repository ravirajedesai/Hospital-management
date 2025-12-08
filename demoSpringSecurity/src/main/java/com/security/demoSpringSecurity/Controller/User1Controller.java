package com.security.demoSpringSecurity.Controller;


import com.security.demoSpringSecurity.Entity.User;
import com.security.demoSpringSecurity.Repository.UserRepository;
import com.security.demoSpringSecurity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class User1Controller {

    private final UserRepository userRepository;
    private final UserService userService;

    public User1Controller(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("register")
    public User userRegister(@RequestBody User user){
    //return userRepository.save(user);
        return userService.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody  User user){
        return userService.verify(user);
//        var u =userRepository.findByName(user.getName());
//        if (Objects.isNull(u))
//        return "success";
//        else
//            return "Fail";
    }
}
