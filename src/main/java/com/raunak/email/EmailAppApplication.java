package com.raunak.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = " com.raunak.email.*")
@EnableJpaRepositories("com.raunak.email.*")
@EntityScan("com.raunak.email.*") 
public class EmailAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailAppApplication.class, args);
	}

}
