package com.peterpopma.easysix.domain.repository;

import com.peterpopma.easysix.domain.entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DomainRepository extends JpaRepository<Domain, UUID> {
}

