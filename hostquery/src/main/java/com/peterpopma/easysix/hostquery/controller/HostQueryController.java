package com.peterpopma.easysix.hostquery.controller;

import com.peterpopma.easysix.hostquery.dto.HostDto;
import com.peterpopma.easysix.hostquery.service.HostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/host")
@Slf4j
public class HostQueryController {

    @Autowired
    HostService hostService;

    @GetMapping("/{hostId}")
    public HostDto hostInfo(@PathVariable UUID hostId)
    {
        HostDto hostObject = hostService.findHostById(hostId);
        log.debug("hostInfo: " + hostId);

        return hostObject;
    }

    @GetMapping("")
    public List<UUID> getAllHosts()
    {
        List<UUID> hostList = hostService.findAllHosts();
        log.debug("requested all hosts");

        return hostList;
    }
}
