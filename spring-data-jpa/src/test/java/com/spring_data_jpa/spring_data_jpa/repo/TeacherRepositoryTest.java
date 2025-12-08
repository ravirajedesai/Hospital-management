package com.spring_data_jpa.spring_data_jpa.repo;

import com.spring_data_jpa.spring_data_jpa.entity.Course;
import com.spring_data_jpa.spring_data_jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseJava= Course.builder()
                .title("Java")
                .credit(5)
                .build();
        Course courseDBA= Course.builder()
                .title("DBA")
                .credit(6)
                .build();
        Teacher teacher= Teacher.builder()
                .firstName("MP")
                .lastName("patil")
                .courses(List.of(courseJava,courseDBA)).build();
        teacherRepository.save(teacher);
    }

}