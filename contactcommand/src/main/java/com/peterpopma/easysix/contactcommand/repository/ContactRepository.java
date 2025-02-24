package com.peterpopma.easysix.contactcommand.repository;

import com.peterpopma.easysix.contactcommand.dao.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, UUID> {

}

