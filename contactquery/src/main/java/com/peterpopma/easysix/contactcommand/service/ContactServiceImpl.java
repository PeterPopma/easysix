package com.peterpopma.easysix.contactcommand.service;

import com.peterpopma.easysix.contactcommand.dto.ContactDto;
import com.peterpopma.easysix.contactcommand.entity.Contact;
import com.peterpopma.easysix.contactcommand.entity.PostalInfo;
import com.peterpopma.easysix.contactcommand.exception.ContactNotFoundException;
import com.peterpopma.easysix.contactcommand.repository.ContactRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactServiceImpl(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    public ContactDto create(ContactDto dto) {
        Contact contact = contactMapper.toEntity(dto);
        contact.setCrDate(LocalDateTime.now());
        for (PostalInfo postalInfo : contact.getPostalInfos()) {
            postalInfo.setContact(contact);
            if (postalInfo.getAddr() != null) {
                postalInfo.getAddr().setPostalInfo(postalInfo);
            }
        }
        Contact saved = contactRepository.save(contact);
        return contactMapper.toDto(saved);
    }

    public ContactDto update(UUID id, ContactDto dto) {
        Contact existing = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(id));

        // update fields – you can make this smarter with MapStruct @MappingTarget
        Contact updated = contactMapper.toEntity(dto);
        updated.setId(existing.getId());
        return contactMapper.toDto(contactRepository.save(updated));
    }

    public void delete(UUID id) {
        if (!contactRepository.existsById(id)) {
            throw new ContactNotFoundException(id);
        }
        contactRepository.deleteById(id);
    }
}
