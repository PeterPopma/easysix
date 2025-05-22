package com.peterpopma.easysix.zonefilegenerator.repository;

import com.peterpopma.easysix.zonefilegenerator.entity.HostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HostRepository extends JpaRepository<HostEntity, UUID> {
    /**
     * Find all Host entities associated with a specific domain ID.
     * @param domainId The UUID of the domain.
     * @return List of Host entities linked to the domain.
     */
    List<HostEntity> findByDomainId(UUID domainId);
}

