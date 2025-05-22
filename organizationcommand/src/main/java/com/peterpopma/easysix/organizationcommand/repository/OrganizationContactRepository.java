package com.peterpopma.easysix.organizationcommand.repository;

import com.peterpopma.easysix.organizationcommand.entity.OrganizationContact;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface OrganizationContactRepository extends JpaRepository<OrganizationContact, UUID> {
}

