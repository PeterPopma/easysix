package com.peterpopma.easysix.contactcommand.repository;

import com.peterpopma.easysix.contactcommand.entity.Disclose;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiscloseRepository extends JpaRepository<Disclose, UUID> {
}