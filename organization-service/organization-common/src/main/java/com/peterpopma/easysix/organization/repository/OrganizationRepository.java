package com.peterpopma.easysix.organization.repository;

import com.peterpopma.easysix.organization.entity.Organization;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, UUID> {
    @Query("SELECT o.id FROM Organization o")
    Set<UUID> findAllOrganizationIds();

    @EntityGraph(attributePaths = {
            "statuses",
            "roles",
            "roles.statuses",
            "contacts",
            "postalInfos"
    })
    Optional<Organization> findById(UUID id);
    List<Organization> findByOrgIdIn(List<String> orgIds);
}

