package com.peterpopma.easysix.organization.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.peterpopma.easysix")
@EntityScan(basePackages = "com.peterpopma.easysix.organization.entity")
@EnableJpaRepositories(basePackages = "com.peterpopma.easysix.organization.repository")
@SuppressWarnings("PMD.UseUtilityClass")
public class OrganizationQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationQueryApplication.class, args);
	}

}
