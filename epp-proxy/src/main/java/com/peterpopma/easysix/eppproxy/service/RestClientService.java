package com.peterpopma.easysix.eppproxy.service;

import ietf.params.xml.ns.epp_1.CommandType;
import ietf.params.xml.ns.epp_1.ResponseType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RestClientService {

    private final WebClient webClient;

    public RestClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://spring-boot-service:8080").build();
    }

    public Mono<ResponseType> sendToRestClient(CommandType eppRequest) {
        return webClient.post()
                .uri("/epp/command")
                .body(Mono.just(eppRequest), CommandType.class)
                .retrieve()
                .bodyToMono(ResponseType.class);
    }
}