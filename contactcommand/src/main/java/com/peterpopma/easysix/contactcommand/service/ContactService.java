package com.peterpopma.easysix.contactcommand.service;

import com.peterpopma.easysix.contactcommand.dao.ContactEntity;
import com.peterpopma.easysix.contactcommand.dto.ContactObject;
import com.peterpopma.easysix.contactcommand.repository.ContactRepository;
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
public class ContactService {

    private final ContactRepository contactRepository;

    @Value("${service.simulated-workload}")
    private int simulatedWorkLoad;

    public void createContact(ContactObject contact)
    {
        ContactEntity contactEntity = ContactConverter.toContactEntity(contact);
        contactRepository.save(contactEntity);
    }
    
    public void updateContact(ContactObject contact)
    {
        ContactEntity contactEntity = ContactConverter.toContactEntity(contact);
        Optional<ContactEntity> existingContactOpt = contactRepository.findById(contact.id());

        if (existingContactOpt.isPresent()) {
            ContactEntity updatedContact = ContactConverter.toContactEntity(contact);
            contactRepository.save(updatedContact);
        } else {
            // Handle case where the contact does not exist
            throw new EntityNotFoundException("Contact with ID " + contact.id() + " not found.");
        }
    }
    
    public void deleteContactById(UUID contactId)
    {
        Optional<ContactEntity> existingContactOpt = contactRepository.findById(contactId);

        if (existingContactOpt.isPresent()) {
            contactRepository.deleteById(contactId);
        } else {
            // Handle case where the contact does not exist
            throw new EntityNotFoundException("Contact with ID " + contactId + " not found.");
        }
    }
}
