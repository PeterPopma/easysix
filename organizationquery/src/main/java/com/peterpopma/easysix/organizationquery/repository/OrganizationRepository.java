package com.peterpopma.easysix.organizationquery.repository;

import com.peterpopma.easysix.organizationquery.dao.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationEntity, UUID> {

    @Query("SELECT c.id FROM OrganizationEntity c")
    List<UUID> findAllIds();

}

