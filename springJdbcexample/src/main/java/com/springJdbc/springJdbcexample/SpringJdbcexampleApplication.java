package com.springJdbc.springJdbcexample;

import com.springJdbc.springJdbcexample.Model.Student;
import com.springJdbc.springJdbcexample.Service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringJdbcexampleApplication.class, args);

		Student s=context.getBean(Student.class);

		s.setRollNo(104);
		s.setName("Ravi");
		s.setMarks(75);

		StudentService service=context.getBean(StudentService.class);

		service.addStudent(s);

		List<Student> students=service.getStudent();
		System.out.println(students);
	}

}
