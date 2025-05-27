package com.peterpopma.easysix.contactcommand.repository;

import com.peterpopma.easysix.contactcommand.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StatusRepository extends JpaRepository<Status, UUID> {
    List<Status> findByContactId(UUID contactId);
}
