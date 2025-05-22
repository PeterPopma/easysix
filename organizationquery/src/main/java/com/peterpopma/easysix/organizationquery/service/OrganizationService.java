package com.peterpopma.easysix.organizationquery.service;

import com.peterpopma.easysix.organizationquery.entity.Organization;
import com.peterpopma.easysix.organizationquery.dto.OrganizationDto;
import com.peterpopma.easysix.organizationquery.repository.OrganizationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrganizationService {

    OrganizationRepository organizationRepository;

    @Value("${service.simulated-workload}")
    private int simulatedWorkLoad;

    public OrganizationDto findOrganizationById(UUID organizationId)
    {
        Optional<OrganizationEntity> existingOrganizationOpt = organizationRepository.findById(organizationId);
        if (existingOrganizationOpt.isPresent()) {
            return OrganizationConverter.toDto(existingOrganizationOpt.get());
        } else {
            // Handle case where the organization does not exist
            throw new EntityNotFoundException("Organization with ID " + organizationId + " not found.");
        }
    }

    public List<UUID> findAllOrganizations()
    {
        return organizationRepository.findAllIds();
    }

    private void SimulateWorkload() {
        int limit = simulatedWorkLoad; // Define the upper limit for prime numbers calculation
        int primeCount = 0;

        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }
    }

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2 || number == 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;

        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) return false;
        }
        return true;
    }
}
