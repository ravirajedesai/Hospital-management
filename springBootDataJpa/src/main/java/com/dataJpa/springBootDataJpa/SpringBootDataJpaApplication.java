package com.dataJpa.springBootDataJpa;

import com.dataJpa.springBootDataJpa.entity.Student;
import com.dataJpa.springBootDataJpa.ser.StudentService;
import com.dataJpa.springBootDataJpa.ser.StudentServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringBootDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringBootDataJpaApplication.class, args);

		StudentService stdService= context.getBean(StudentServiceImpl.class);

//		Student std=new Student();
//		std.setName("sup");
//		std.setRollno(9);
//		std.setMarks(60);
//
//		boolean status=stdService.addStudentDetails(std);
//		if(status){
//			System.out.println("Student Inserted Successfully.");
//		}else {
//			System.out.println("Student Not Inserted.");
//		}
		//--------------------------------------------------------------------
//		List<Student> stdlist=stdService.getAllStudents();
//		for (Student std:stdlist){
//			System.out.println("Id: "+std.getId());
//			System.out.println("Name: "+std.getName());
//			System.out.println("RollNo: "+std.getRollno());
//			System.out.println("Marks: "+std.getMarks());
//		}
		//--------------------------------------------------------------------
//		Student std=stdService.getStudentById(12);
//
//		if(std  !=null) {
//			System.out.println("ID: " + std.getId());
//			System.out.println("Name: " + std.getName());
//			System.out.println("Roll No: " + std.getRollno());
//			System.out.println("Marks: " + std.getMarks());
//		}else {
//			System.out.println("Student Not Found.");
//		}
//		boolean status=stdService.updateStudent(2,76);
//		if (status) {
//			System.out.println("Student Updated..");
//		}else {
//			System.out.println("Student Not Updated..");
//		}
		boolean status=stdService.deleteStudentById(2);
		if(status){
			System.out.println("Student Deleted..");
		}else {
			System.out.println("Student Not Deleted..");
		}
	}

}
