package com.peterpopma.easysix.hostquery.service;

import com.peterpopma.easysix.hostquery.entity.HostEntity;
import com.peterpopma.easysix.hostquery.dto.HostDto;
import com.peterpopma.easysix.hostquery.repository.HostRepository;
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
public class HostService {

    HostRepository hostRepository;

    @Value("${service.simulated-workload}")
    private int simulatedWorkLoad;

    public HostDto findHostById(UUID hostId)
    {
        Optional<HostEntity> existingHostOpt = hostRepository.findById(hostId);
        if (existingHostOpt.isPresent()) {
            return HostConverter.toDto(existingHostOpt.get());
        } else {
            // Handle case where the host does not exist
            throw new EntityNotFoundException("Host with ID " + hostId + " not found.");
        }
    }

    public List<UUID> findAllHosts()
    {
        return hostRepository.findAllIds();
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
