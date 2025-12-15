package com.security.security_filter_jwt.repository;

import com.security.security_filter_jwt.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Integer> {

    Users findByusername(String username);
}
