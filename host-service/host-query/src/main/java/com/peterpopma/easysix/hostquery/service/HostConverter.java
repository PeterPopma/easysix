package com.peterpopma.easysix.hostquery.service;

import com.peterpopma.easysix.host.entity.HostEntity;
import com.peterpopma.easysix.host.dto.HostDto;
import org.springframework.stereotype.Service;

@Service
public class HostConverter {

    public static HostDto toDto(HostEntity entity) {
        return new HostDto(
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
