package com.seccuritySpring.security.spring.repository;

import com.seccuritySpring.security.spring.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibRepo extends JpaRepository<Library,Long> {
}
