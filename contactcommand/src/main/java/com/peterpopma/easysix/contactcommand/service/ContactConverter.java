package com.peterpopma.easysix.contactcommand.service;

import com.peterpopma.easysix.contactcommand.dao.ContactEntity;
import com.peterpopma.easysix.contactcommand.dto.ContactObject;

public class ContactConverter {

    public static ContactEntity toContactEntity(ContactObject contactObject) {
        ContactEntity entity = new ContactEntity();

        entity.setId(contactObject.id());
        entity.setRoid(contactObject.roid());
        entity.setStatus(contactObject.status());
        entity.setPostalInfo(contactObject.postalInfo());
        entity.setName(contactObject.name());
        entity.setOrg(contactObject.org());
        entity.setStreet1(contactObject.street1());
        entity.setStreet2(contactObject.street2());
        entity.setStreet3(contactObject.street3());
        entity.setStateProvince(contactObject.stateProvince());
        entity.setPostalCode(contactObject.postalCode());
        entity.setCity(contactObject.city());
        entity.setCountryCode(contactObject.countryCode());
        entity.setVoice(contactObject.voice());
        entity.setFax(contactObject.fax());
        entity.setEmail(contactObject.email());
        entity.setClId(contactObject.clId());
        entity.setCrId(contactObject.crId());
        entity.setCrDate(contactObject.crDate());
        entity.setUpId(contactObject.upId());
        entity.setUpDate(contactObject.upDate());
        entity.setTrDate(contactObject.trDate());
        entity.setAuthInfoPw(contactObject.authInfoPw());
        entity.setAuthInfoExt(contactObject.authInfoExt());
        entity.setDiscloseVoice(contactObject.discloseVoice());
        entity.setDiscloseEmail(contactObject.discloseEmail());

        return entity;
    }
}

