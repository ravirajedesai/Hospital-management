package com.spring_data_jpa.spring_data_jpa.repo;

import com.spring_data_jpa.spring_data_jpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
