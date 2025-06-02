package com.peterpopma.easysix.organization.command;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.peterpopma.easysix.organization.entity")
@EnableJpaRepositories(basePackages = "com.peterpopma.easysix.organization.repository")
public class OrganizationCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationCommandApplication.class, args);
	}

}
