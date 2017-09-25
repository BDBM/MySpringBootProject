package com.misl.ums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.misl")
@EnableJpaRepositories("com.misl")
@EntityScan("com.misl")
public class UmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmsApplication.class, args);
	}
}
