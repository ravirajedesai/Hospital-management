package com._minRestApi.RestApi.User;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {
    UserDaoService service;

    public UserResource (UserDaoService service) {
        this.service=service;
    }
    @GetMapping("/users")
    public List<user>getAllUser(){
        return service.findAll();
    }
    @GetMapping("/users/{id}")
    public user getById(@PathVariable int id){
        return service.getUserById(id);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteById(id);
    }
    @PostMapping("/users")
    public ResponseEntity<user> createUser(@Valid @RequestBody user user){
        service.save(user);
        return ResponseEntity.created(null).build();
    }
}
