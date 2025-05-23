package com.peterpopma.easysix.zonefilegenerator.repository;

import com.peterpopma.easysix.zonefilegenerator.entity.DomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DomainRepository extends JpaRepository<DomainEntity, UUID> {

}

