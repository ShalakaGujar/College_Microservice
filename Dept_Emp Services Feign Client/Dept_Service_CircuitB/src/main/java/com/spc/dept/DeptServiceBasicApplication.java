package com.spc.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class DeptServiceBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeptServiceBasicApplication.class, args);
	}

}
