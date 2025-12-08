package com.microservices.demoMicroservices.Controller;

import com.microservices.demoMicroservices.Entity.User;
import com.microservices.demoMicroservices.Service.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private services services;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId){

        User user = this.services.getUser(userId);
        List contacts =restTemplate.getForObject(
                "http://localhost:contact-server/contact/user/"+user.getId(),
                List.class);
        user.setContacts(contacts);
        return user;

    }
}
