package com.peterpopma.easysix.domaintransfer.service;

import com.peterpopma.easysix.domaintransfer.dto.AuthInfo;
import com.peterpopma.easysix.domaintransfer.dto.ContactDto;
import com.peterpopma.easysix.domaintransfer.dto.DomainDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Slf4j
@Service
public class DomainTransferService {
    @Value("${service.simulated-workload}")
    private int simulatedWorkLoad;

    @Value("${service.domaininfo.uri}")
    private String domainInfoURI;

    @Value("${service.domainupdate.uri}")
    private String domainUpdateURI;

    @Value("${service.contactcreate.uri}")
    private String contactCreateURI;

    private final WebClient.Builder webClientBuilder;

    public DomainTransferService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public void transferDomain(String domainName)
    {
        SimulateWorkload();
        DomainDto domainObject = webClientBuilder.build()
                .get()
                .uri(domainInfoURI + "/" + domainName)
                .retrieve()
                .bodyToMono(DomainDto.class).block();

        // create 3 contacts for the receiving registrar. they should be copies of the former registrar.
        ContactDto contactObject = new ContactDto();
        AuthInfo authInfo = new AuthInfo();
        contactObject.setAuthInfo(authInfo);

        var response = webClientBuilder.build()
                .post()
                .uri(contactCreateURI)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(contactObject), ContactDto.class)
                .retrieve()
                .bodyToMono(String.class).block();

        response = webClientBuilder.build()
                .post()
                .uri(contactCreateURI)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(contactObject), ContactDto.class)
                .retrieve()
                .bodyToMono(String.class).block();

        response = webClientBuilder.build()
                .post()
                .uri(contactCreateURI)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(contactObject), ContactDto.class)
                .retrieve()
                .bodyToMono(String.class).block();

        // update the domain with new contacts and new owner
        response = webClientBuilder.build()
                .put()
                .uri(domainUpdateURI)
                .body(Mono.just(domainObject), DomainDto.class)
                .retrieve()
                .bodyToMono(String.class).block();
    }

    private void SimulateWorkload() {
        int limit = simulatedWorkLoad; // Define the upper limit for prime numbers calculation
        int primeCount = 0;

        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }
    }

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2 || number == 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;

        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) return false;
        }
        return true;
    }
}
