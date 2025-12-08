package com.revision.startspringboot;

import com.revision.startspringboot.Controller.UserService;
import com.revision.startspringboot.Model.UserEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StartspringbootApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(StartspringbootApplication.class, args);

		UserService service=context.getBean(UserService.class);

		UserEntity user=new UserEntity();

		user.setRollno(101);
		user.setName("Aniket");

		service.save(user);
	}

}
