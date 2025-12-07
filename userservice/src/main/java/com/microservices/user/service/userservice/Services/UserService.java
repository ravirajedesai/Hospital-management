package com.microservices.user.service.userservice.Services;

import com.microservices.user.service.userservice.Entites.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User>getAllUser();
    User getUserById(String userId);

    //update user
    //delete user
}
