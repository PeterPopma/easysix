package com.peterpopma.easysix.contactquery.service;

import com.peterpopma.easysix.contactquery.dao.ContactEntity;
import com.peterpopma.easysix.contactquery.dto.ContactObject;

public class ContactConverter {

    public static ContactObject toContactObject(ContactEntity entity) {
        return new ContactObject(
                entity.getId(),
                entity.getRoid(),
                entity.getStatus(),
                entity.getPostalInfo(),
                entity.getName(),
                entity.getOrg(),
                entity.getStreet1(),
                entity.getStreet2(),
                entity.getStreet3(),
                entity.getStateProvince(),
                entity.getPostalCode(),
                entity.getCity(),
                entity.getCountryCode(),
                entity.getVoice(),
                entity.getFax(),
                entity.getEmail(),
                entity.getClId(),
                entity.getCrId(),
                entity.getCrDate(),
                entity.getUpId(),
                entity.getUpDate(),
                entity.getTrDate(),
                entity.getAuthInfoPw(),
                entity.getAuthInfoExt(),
                entity.isDiscloseVoice(),
                entity.isDiscloseEmail()
        );
    }
}
