package com.security.demoSpringSecurity.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    @GetMapping("/welcome")
    public String welcome(){
        return "WelCome";
    }

    @PostMapping("/welcome")
    public ResponseEntity<Object>adduser(@RequestBody User user){
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }
    @GetMapping("/csrf")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
