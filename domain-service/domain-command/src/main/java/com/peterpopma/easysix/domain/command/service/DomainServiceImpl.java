package com.peterpopma.easysix.domain.command.service;

import com.peterpopma.easysix.domain.entity.Domain;
import com.peterpopma.easysix.domain.exception.DomainNotFoundException;
import com.peterpopma.easysix.domain.repository.DomainRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DomainServiceImpl implements DomainService {

    private final DomainRepository domainRepository;

    @Override
    @Transactional
    public Domain save(Domain domain) {
        // Automatically set createdAt and updatedAt if needed
        Instant now = Instant.now();

        if (domain.getId() == null) {
            domain.setCreatedAt(now);
        }

        domain.setUpdatedAt(now);
        return domainRepository.save(domain);
    }

    @Override
    @Transactional
    public Domain findById(UUID id) {
        return domainRepository.findById(id)
                .orElseThrow(() -> new DomainNotFoundException(id));
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        if (!domainRepository.existsById(id)) {
            throw new DomainNotFoundException(id);
        }
        domainRepository.deleteById(id);
    }

}
