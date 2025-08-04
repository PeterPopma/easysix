package com.peterpopma.easysix.contactcommand.repository;

import com.peterpopma.easysix.contactcommand.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
