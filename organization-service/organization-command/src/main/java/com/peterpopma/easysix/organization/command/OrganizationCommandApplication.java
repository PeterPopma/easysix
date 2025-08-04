package com.peterpopma.easysix.organization.command;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.peterpopma.easysix.organization")
@EnableJpaRepositories(basePackages = "com.peterpopma.easysix.organization.repository")
@SpringBootApplication(scanBasePackages = "com.peterpopma.easysix")
@SuppressWarnings("PMD.UseUtilityClass")
public class OrganizationCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationCommandApplication.class, args);
	}

}
