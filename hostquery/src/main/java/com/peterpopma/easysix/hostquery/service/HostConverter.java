package com.peterpopma.easysix.hostquery.service;

import com.peterpopma.easysix.hostquery.dao.HostEntity;
import com.peterpopma.easysix.hostquery.dto.HostObject;
import org.springframework.stereotype.Service;

@Service
public class HostConverter {

    public static HostObject toDto(HostEntity entity) {
        return new HostObject(
            entity.getId(),
            entity.getName(),
            entity.getRoid(),
            entity.getStatus(),
            entity.getIpv4(),
            entity.getIpv6(),
            entity.getClId(),
            entity.getCrId(),
            entity.getCrDate(),
            entity.getUpId(),
            entity.getUpDate(),
            entity.getTrDate()
        );
    }
}
