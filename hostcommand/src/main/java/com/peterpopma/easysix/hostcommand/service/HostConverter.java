package com.peterpopma.easysix.hostcommand.service;

import com.peterpopma.easysix.hostcommand.dao.HostEntity;
import com.peterpopma.easysix.hostcommand.dto.HostObject;

public class HostConverter {

    public static HostEntity toHostEntity(HostObject hostObject) {
        HostEntity entity = new HostEntity();
        
        entity.setId(hostObject.id());
        entity.setName(hostObject.name());
        entity.setRoid(hostObject.roid());
        entity.setStatus(hostObject.status());
        entity.setIpv4(hostObject.ipv4());
        entity.setIpv6(hostObject.ipv6());
        entity.setClId(hostObject.clId());
        entity.setCrId(hostObject.crId());
        entity.setCrDate(hostObject.crDate());
        entity.setUpId(hostObject.upId());
        entity.setUpDate(hostObject.upDate());
        entity.setTrDate(hostObject.trDate());
        
        return entity;
    }
}