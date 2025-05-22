package com.peterpopma.easysix.hostcommand.repository;

import com.peterpopma.easysix.hostcommand.entity.HostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HostRepository extends JpaRepository<HostEntity, UUID> {

}

