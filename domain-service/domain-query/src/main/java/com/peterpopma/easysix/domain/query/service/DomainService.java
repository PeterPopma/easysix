package com.peterpopma.easysix.domain.query.service;

import com.peterpopma.easysix.domain.entity.Domain;

import java.util.UUID;

public interface DomainService {
    Domain findById(UUID id);
    
}

