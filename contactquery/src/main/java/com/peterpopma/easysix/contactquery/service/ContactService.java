package com.peterpopma.easysix.contactquery.service;

import com.peterpopma.easysix.contactquery.dao.ContactEntity;
import com.peterpopma.easysix.contactquery.dto.ContactObject;
import com.peterpopma.easysix.contactquery.repository.ContactRepository;
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
public class ContactService {

    ContactRepository contactRepository;

    @Value("${service.simulated-workload}")
    private int simulatedWorkLoad;

    public ContactObject findContactById(UUID contactId)
    {
        Optional<ContactEntity> existingContactOpt = contactRepository.findById(contactId);
        if (existingContactOpt.isPresent()) {
            return ContactConverter.toContactObject(existingContactOpt.get());
        } else {
            // Handle case where the contact does not exist
            throw new EntityNotFoundException("Contact with ID " + contactId + " not found.");
        }
    }

    public List<UUID> findAllContacts()
    {
        return contactRepository.findAllIds();
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
