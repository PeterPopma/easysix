package com.peterpopma.easysix.zonefilegenerator.controller;

import com.peterpopma.easysix.zonefilegenerator.service.ZoneFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/zonefile")
public class ZoneFileController {

    @Autowired
    private ZoneFileService zoneFileService;

    @GetMapping("/{domainId}")
    public String getZoneFile(@PathVariable UUID domainId) {
        return zoneFileService.generateZoneFile(domainId);
    }
}