package com.spring_data_jpa.spring_data_jpa.repo;

import com.spring_data_jpa.spring_data_jpa.entity.Course;
import com.spring_data_jpa.spring_data_jpa.entity.Student;
import com.spring_data_jpa.spring_data_jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest{
    @Autowired
    CourseRepository courseRepository;

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher= Teacher.builder()
                .firstName("matuti")
                .lastName("kambale")
                .build();
        Course course= Course.builder()
                .title("Python")
                .credit(4)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }
    @Test
    public void saveStudentWithCourseAndTeacher(){
        Teacher teacher= Teacher.builder()
                .firstName("supriya")
                .lastName("shinde")
                .build();
        Student student= Student.builder()
                .firstName("amal")
                .lastName("ab")
                .emailId("abc@gmail")
                .build();
        Course course= Course.builder()
                .title("AI")
                .credit(8)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

}