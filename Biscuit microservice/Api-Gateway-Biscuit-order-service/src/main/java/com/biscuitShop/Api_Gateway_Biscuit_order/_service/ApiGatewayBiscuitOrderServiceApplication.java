package com.biscuitShop.Api_Gateway_Biscuit_order._service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayBiscuitOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayBiscuitOrderServiceApplication.class, args);
	}

}
