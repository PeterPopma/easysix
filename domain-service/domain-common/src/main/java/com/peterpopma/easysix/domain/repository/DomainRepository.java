package com.peterpopma.easysix.domain.repository;

import com.peterpopma.easysix.domain.entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;
import java.util.UUID;

public interface DomainRepository extends JpaRepository<Domain, UUID> {
    @Query("SELECT d.id FROM Domain d")
    Set<UUID> findAllDomainIds();
}

