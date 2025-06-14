package com.peterpopma.easysix.organization.repository;

import com.peterpopma.easysix.organization.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, UUID> {
    @Query("SELECT o.id FROM Organization o")
    Set<UUID> findAllOrganizationIds();
}

