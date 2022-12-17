package com.github.MrPatronO.carworkshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
public class CarWorkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarWorkshopApplication.class, args);
	}

}
