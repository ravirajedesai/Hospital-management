package com.microservices.user.service.userservice.Repository;

import com.microservices.user.service.userservice.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
