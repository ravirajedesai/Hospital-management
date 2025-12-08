package com.microservices.demoMicroservices.Service;

import com.microservices.demoMicroservices.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements services{

    List<User>list=List.of(
            new User(100,"ravi","12345"),
            new User(101,"vaibhav","67890"),
        new User(102,"suraj","45678")
    );
    @Override
    public User getUser(Long id) {
        return this
                .list
                .stream()
                .filter(user -> id.equals(id))
                .findAny()
                .orElse(null);
    }
}
