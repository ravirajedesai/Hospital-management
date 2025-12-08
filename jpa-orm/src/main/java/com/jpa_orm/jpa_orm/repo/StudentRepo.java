package com.jpa_orm.jpa_orm.repo;

import com.jpa_orm.jpa_orm.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
}
