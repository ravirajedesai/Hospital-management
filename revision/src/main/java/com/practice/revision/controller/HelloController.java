package com.practice.revision.controller;

import com.practice.revision.model.HelloUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class HelloController {

    @GetMapping("/hello-user")
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("Hello-World");
    }
    @GetMapping("/get-user")
    public ResponseEntity<HelloUser> getUser(){
        HelloUser user=new HelloUser();
        user.setId("1");
        user.setName("Prashant");
        user.setEmail("Prashant@gmail.com");

        return ResponseEntity.ok(user);
    }
    @GetMapping("/{id}/{id2}")
    public ResponseEntity<String> pathVariable(@PathVariable String id,
                                               @PathVariable String id2){
        return ResponseEntity.ok("PathVariable: "+id+":"+id2);
    }
    @GetMapping("/name")
    public ResponseEntity<String> requester(
            @RequestParam String name,
            @RequestParam(required = false,defaultValue = "") String email){
        String response="Your Name Is: "+name+
                (email.isEmpty() ?"_":"Email Id :"+email);
        return ResponseEntity.ok(response);
    }
}
