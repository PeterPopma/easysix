package com.peterpopma.easysix.organizationcommand.repository;

import com.peterpopma.easysix.organizationcommand.dao.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationEntity, UUID> {

}

