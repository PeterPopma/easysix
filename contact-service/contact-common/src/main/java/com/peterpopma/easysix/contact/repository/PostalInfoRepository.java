package com.peterpopma.easysix.contactcommand.repository;

import com.peterpopma.easysix.contactcommand.entity.PostalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostalInfoRepository extends JpaRepository<PostalInfo, UUID> {
    List<PostalInfo> findByContactId(UUID contactId);
}