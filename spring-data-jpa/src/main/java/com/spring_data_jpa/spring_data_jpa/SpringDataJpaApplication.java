package com.spring_data_jpa.spring_data_jpa;

import com.spring_data_jpa.spring_data_jpa.entity.Guardian;
import com.spring_data_jpa.spring_data_jpa.entity.Student;
import com.spring_data_jpa.spring_data_jpa.repo.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);


        Student student=new Student(1L,"abc","xyz","abc@gmail",new Guardian());

        Guardian guardian=new Guardian("ram","ram@gmail","9999999999");

	}

}
