package com.peterpopma.easysix.organization.repository;

import com.peterpopma.easysix.organization.entity.OrganizationContact;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface OrganizationContactRepository extends JpaRepository<OrganizationContact, UUID> {
}

