package com.spring_data_jpa.spring_data_jpa.repo;

import com.spring_data_jpa.spring_data_jpa.entity.Course;
import com.spring_data_jpa.spring_data_jpa.entity.CourseMaterial;
import com.spring_data_jpa.spring_data_jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void SaveCourseMaterial(){
        Course course=Course.builder()
                .title("microservices")
                .credit(7)
                .build();
        CourseMaterial courseMaterial=CourseMaterial.builder()
                .url("yahoo.com")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }
    @Test
    public void PrintAllCourseMaterials(){
        List<CourseMaterial> courseMaterials=
                courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }

}