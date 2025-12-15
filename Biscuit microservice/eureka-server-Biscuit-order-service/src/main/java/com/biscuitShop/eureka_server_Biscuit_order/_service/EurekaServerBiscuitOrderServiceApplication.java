package com.biscuitShop.eureka_server_Biscuit_order._service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerBiscuitOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerBiscuitOrderServiceApplication.class, args);
	}

}
