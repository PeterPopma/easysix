package com.peterpopma.easysix.contactquery.repository;

import com.peterpopma.easysix.contactquery.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, UUID> {

    @Query("SELECT c.id FROM ContactEntity c")
    List<UUID> findAllIds();

}

