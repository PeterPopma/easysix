package com.peterpopma.easysix.domain.query.service;

import com.peterpopma.easysix.domain.entity.Domain;
import com.peterpopma.easysix.domain.exception.DomainNotFoundException;
import com.peterpopma.easysix.domain.repository.DomainRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DomainServiceImpl implements DomainService {

    private final DomainRepository domainRepository;

    @Override
    @Transactional(readOnly = true)
    public Domain findById(UUID id) {
        return domainRepository.findById(id)
                .orElseThrow(() -> new DomainNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public Set<UUID> findAllDomainIds() {
        return domainRepository.findAllDomainIds();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean exists(UUID id){
        return domainRepository.existsById(id);
    }
}
