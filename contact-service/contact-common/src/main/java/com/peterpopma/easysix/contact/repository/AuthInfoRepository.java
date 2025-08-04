package com.peterpopma.easysix.contactcommand.repository;

import com.peterpopma.easysix.contactcommand.entity.AuthInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthInfoRepository extends JpaRepository<AuthInfo, UUID> {
}