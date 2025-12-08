package com.dataJpaEx.DataJpa;

import com.dataJpaEx.DataJpa.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(DataJpaApplication.class, args);

		StudentRepo repo=context.getBean(StudentRepo.class);

//		Student s1=new Student();
//		s1.setRollno(101);
//		s1.setName("Ravi");
//		repo.save(s1);
//
//		Student s2=new Student();
//		s2.setRollno(102);
//		s2.setName("ram");
//		repo.save(s2);
//
//		Student s3=new Student();
//		s3.setRollno(103);
//		s3.setName("suraj");
//		repo.save(s3);

		//Optional<Student> s=repo.findById(102);
		//System.out.println(s.orElse(new Student()));

		//repo.findByName("suraj");
		System.out.println(repo.findByName("ram"));
	}

}
