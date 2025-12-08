package com.college_student.company_selection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CompanySelectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanySelectionApplication.class, args);
	}

}
