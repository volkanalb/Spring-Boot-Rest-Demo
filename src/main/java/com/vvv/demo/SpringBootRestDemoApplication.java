package com.vvv.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.*"})
public class SpringBootRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestDemoApplication.class, args);
	}

}
