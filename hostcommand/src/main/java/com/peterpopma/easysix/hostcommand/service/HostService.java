package com.peterpopma.easysix.hostcommand.service;

import com.peterpopma.easysix.hostcommand.entity.HostEntity;
import com.peterpopma.easysix.hostcommand.dto.HostDto;
import com.peterpopma.easysix.hostcommand.repository.HostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class HostService {

    private final HostRepository hostRepository;

    @Value("${service.simulated-workload}")
    private int simulatedWorkLoad;

    public void createHost(HostDto host)
    {
        HostEntity hostEntity = HostConverter.toHostEntity(host);
        hostRepository.save(hostEntity);
    }
    
    public void updateHost(HostDto host)
    {
        HostEntity hostEntity = HostConverter.toHostEntity(host);
        Optional<HostEntity> existingHostOpt = hostRepository.findById(host.id());

        if (existingHostOpt.isPresent()) {
            HostEntity updatedHost = HostConverter.toHostEntity(host);
            hostRepository.save(updatedHost);
        } else {
            // Handle case where the host does not exist
            throw new EntityNotFoundException("Host with ID " + host.id() + " not found.");
        }
    }
    
    public void deleteHostById(UUID hostId)
    {
        Optional<HostEntity> existingHostOpt = hostRepository.findById(hostId);

        if (existingHostOpt.isPresent()) {
            hostRepository.deleteById(hostId);
        } else {
            // Handle case where the host does not exist
            throw new EntityNotFoundException("Host with ID " + hostId + " not found.");
        }
    }
}
