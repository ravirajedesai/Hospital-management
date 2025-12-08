package com.dataJpa.springBootDataJpa.repo;

import com.dataJpa.springBootDataJpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {


}
