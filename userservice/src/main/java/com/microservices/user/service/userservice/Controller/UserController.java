package com.microservices.user.service.userservice.Controller;

import com.microservices.user.service.userservice.Entites.User;
import com.microservices.user.service.userservice.Services.UserService;
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//import io.github.resilience4j.retry.annotation.Retry;
//import io.github.resilience4j.spring6.fallback.FallbackMethod;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  // private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
       // logger.info("Creating new user: {}", user.getEmail());
        User user1 = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //int retryCount=1;

    @GetMapping("/{userId}")
    //@CircuitBreaker(name="RatingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    //@Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
       // logger.info("Get Single User Handler: UserController");
        //logger.info("Retry Count: {}",retryCount);
       // retryCount++;
        User userById = userService.getUserById(userId);
        return ResponseEntity.ok(userById);
    }
    //Creating fallBackMethod for CircuitBreaker
    public ResponseEntity<User> ratingHotelFallback(String userId,Throwable t){
        //logger.info("FallBack is executed Because Service is Down: ",t.getMessage());
        //logger.error("Fallback executed for userId: {}. Error: {}", userId, t.getMessage());
        User user= User
                .builder()
                .email("dummy@gmail.com")
                .name("Dummy")
                .about("This user is created dummy because service is down.")
                .userId("1234")
                .build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }
}
