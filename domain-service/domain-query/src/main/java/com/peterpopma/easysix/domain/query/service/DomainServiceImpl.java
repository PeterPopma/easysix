package com.peterpopma.easysix.domain.query.service;

import com.peterpopma.easysix.domain.entity.Domain;
import com.peterpopma.easysix.domain.exception.DomainNotFoundException;
import com.peterpopma.easysix.domain.repository.DomainRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DomainServiceImpl implements DomainService {

    private final DomainRepository domainRepository;

    @Override
    @Transactional
    public Domain findById(UUID id) {
        return domainRepository.findById(id)
                .orElseThrow(() -> new DomainNotFoundException(id));
    }

}
