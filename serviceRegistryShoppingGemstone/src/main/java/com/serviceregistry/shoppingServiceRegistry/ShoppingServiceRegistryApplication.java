package com.serviceregistry.shoppingServiceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ShoppingServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingServiceRegistryApplication.class, args);
	}

}
