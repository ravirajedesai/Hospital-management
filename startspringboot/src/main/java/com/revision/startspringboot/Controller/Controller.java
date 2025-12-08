package com.revision.startspringboot.Controller;

import com.revision.startspringboot.Model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/home")
public class Controller {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>>getAllUser(){
        List<UserEntity>alluser=userService.findAll();
        return new ResponseEntity<>(alluser,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object>getUserById(@PathVariable long id){
        Optional<UserEntity> user=userService.findById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object>addUser(@RequestBody UserEntity user){
        userService.save(user);
        return new ResponseEntity<>("User Added Successfully", HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object>deleteUser(@PathVariable long id){
        userService.deleteById(id);
        return new ResponseEntity<>("User Deleted Successfully.",HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object>updateUser(@PathVariable long id,@RequestBody UserEntity user){
        Optional<UserEntity>existingUser=userService.findById(id);
        if(existingUser.isPresent()) {
            UserEntity availableUser = existingUser.get();
            availableUser.setRollno(user.getRollno());
            availableUser.setName(user.getName());
            UserEntity updatedUser=userService.save(availableUser);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("User Not Found.", HttpStatus.NOT_FOUND);
        }
        }
}
