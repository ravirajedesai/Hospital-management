package com.spring_data_jpa.spring_data_jpa.repo;

import com.spring_data_jpa.spring_data_jpa.entity.CourseMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {

}
