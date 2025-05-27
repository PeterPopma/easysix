package com.peterpopma.easysix.domain.command;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.peterpopma.easysix")
@EntityScan(basePackages = "com.peterpopma.easysix.domain.entity")
@EnableJpaRepositories(basePackages = "com.peterpopma.easysix.domain.repository")
public class DomainCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomainCommandApplication.class, args);
	}

}
