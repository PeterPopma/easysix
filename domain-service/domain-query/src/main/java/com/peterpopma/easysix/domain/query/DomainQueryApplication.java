package com.peterpopma.easysix.domain.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.peterpopma.easysix")
@EntityScan(basePackages = "com.peterpopma.easysix.domain.entity")
@EnableJpaRepositories(basePackages = "com.peterpopma.easysix.domain.repository")
public class DomainQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomainQueryApplication.class, args);
	}

}
