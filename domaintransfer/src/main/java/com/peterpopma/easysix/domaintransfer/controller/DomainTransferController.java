package com.peterpopma.easysix.domaintransfer.controller;

import com.peterpopma.easysix.domaintransfer.service.DomainTransferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/domain/transfer")
@Slf4j
public class DomainTransferController {

    @Autowired
    DomainTransferService domainTransferService;

    @PostMapping("/{domainId}")
    public ResponseEntity<String> domainTransfer(@PathVariable String domainId)
    {
        domainTransferService.transferDomain(domainId);
        log.info("domainTransfer: " + domainId);

        return new ResponseEntity("transferred domain " + domainId, HttpStatus.OK);
    }
}
