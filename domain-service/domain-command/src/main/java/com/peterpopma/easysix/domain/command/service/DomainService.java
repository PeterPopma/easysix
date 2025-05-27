package com.peterpopma.easysix.domain.command.service;

import com.peterpopma.easysix.domain.entity.Domain;

import java.util.UUID;

public interface DomainService {
    Domain save(Domain domain);
    Domain findById(UUID id);
    void deleteById(UUID id);
}

