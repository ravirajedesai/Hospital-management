package com.seccuritySpring.security.spring.repository;

import com.seccuritySpring.security.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
