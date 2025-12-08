package com.example.SpringDataJPA;

import com.example.SpringDataJPA.model.Student;
import com.example.SpringDataJPA.model.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringDataJpaApplication.class, args);
		StudentRepo repo=context.getBean(StudentRepo.class);

		Student s1=context.getBean(Student.class);
		Student s2= context.getBean(Student.class);
		Student s3= context.getBean(Student.class);
//
//		s1.setRollno(101);
//		s1.setName("rahul");
//		s1.setMarks(89);
//
//		s2.setRollno(102);
//		s2.setName("abhi");
//		s2.setMarks(70);
//
//		s1.setRollno(103);
//		s1.setName("jay");
//		s1.setMarks(85);
//
//		repo.save(s1);
//		repo.save(s2);
//		repo.save(s3);

		Optional<Student> s=repo.findById(103);
		System.out.println(s.orElse(new Student()));
	}

}
