package com.peterpopma.easysix.organization.query.service;

import com.peterpopma.easysix.organization.entity.*;
import com.peterpopma.easysix.organization.exception.OrganizationNotFoundException;
import com.peterpopma.easysix.organization.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    @Transactional(readOnly = true)
    public Organization findById(UUID id) {
        return organizationRepository.findById(id)
                .orElseThrow(() -> new OrganizationNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public Set<UUID> findAllOrganizationIds() {
        return organizationRepository.findAllOrganizationIds();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean exists(UUID id){
        return organizationRepository.existsById(id);
    }
}
