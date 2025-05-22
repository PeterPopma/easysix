package com.peterpopma.easysix.hostcommand.controller;

import com.peterpopma.easysix.hostcommand.dto.HostDto;
import com.peterpopma.easysix.hostcommand.service.HostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/host")
@Slf4j
public class HostCommandController {

    @Autowired
    HostService hostService;

    @PostMapping("")
    public ResponseEntity<String> hostCreate(@RequestBody HostDto host )
    {
        hostService.createHost(host);
        log.debug("hostCreate: " + host.id());

        return new ResponseEntity("created host " + host.id(), HttpStatus.OK);
    }
    
    @PutMapping("")
    public ResponseEntity<String> hostUpdate(@RequestBody HostDto host )
    {
        hostService.updateHost(host);
        log.debug("hostUpdate: " + host.id());

        return new ResponseEntity("updated host " + host.id(), HttpStatus.OK);
    }
    
    @DeleteMapping("/{hostId}")
    public ResponseEntity<String> hostDelete(@PathVariable UUID hostId)
    {
        hostService.deleteHostById(hostId);
        log.debug("hostDelete: " + hostId);

        return new ResponseEntity("deleted host " + hostId, HttpStatus.OK);
    }

}
