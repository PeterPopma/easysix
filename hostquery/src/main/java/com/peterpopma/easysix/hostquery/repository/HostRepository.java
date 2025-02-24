package com.peterpopma.easysix.hostquery.repository;

import com.peterpopma.easysix.hostquery.dao.HostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface HostRepository extends JpaRepository<HostEntity, UUID> {

    @Query("SELECT c.id FROM HostEntity c")
    List<UUID> findAllIds();

}

