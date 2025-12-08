package com.revision.springFirstrevision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringFirstrevisionApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringFirstrevisionApplication.class, args);
		Alien alien = context.getBean(Alien.class);

		alien.display();
	}

}
