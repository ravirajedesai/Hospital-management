package com.springSecurityPractice.securitypractice.Dao;

import com.springSecurityPractice.securitypractice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
