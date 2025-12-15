package com.security.security_filter_jwt.controller;

import com.security.security_filter_jwt.entity.Users;
import com.security.security_filter_jwt.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    MyUserDetailService service;

    @GetMapping
    public String student(){
        return "Student";
    }
//    @PostMapping
//    public Users addUser(@RequestBody Users users){
//        return service.adduser(users);
//    }
}
