package com.peterpopma.easysix.api_gateway.config;

import com.peterpopma.easysix.api_gateway.filter.RouteCounterFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class GatewayConfig {
/*
    private final RouteCounterFilter routeCounterFilter;

    public GatewayConfig(RouteCounterFilter routeCounterFilter) {
        this.routeCounterFilter = routeCounterFilter;
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("domaintransfer_metrics_route", r -> r.path("/domaintransfer/actuator/**")
                        .filters(f -> f.stripPrefix(1)) // Strips "/domaintransfer" from the path
                        .uri("http://domaintransfer-service/actuator"))

                .route("actuator_route", r -> r.path("/actuator/**")
                        .uri("http://api-gateway-service.default.svc.cluster.local:8080"))

                .route("domaintransfer", r -> r.path("/domain/transfer/**")
                        .and().method("POST")
                        .filters(f -> f.filter(routeCounterFilter.apply(new RouteCounterFilter.Config())))
                        .uri("http://domaintransfer-service/domain/transfer"))

                .route("domainupdate", r -> r.path("/domain/**")
                        .and().method("PUT")
                        .filters(f -> f.filter(routeCounterFilter.apply(new RouteCounterFilter.Config())))
                        .uri("http://domainupdate-service/domain"))

                .route("domaininfo", r -> r.path("/domain/**")
                        .and().method("GET")
                        .filters(f -> f.filter(routeCounterFilter.apply(new RouteCounterFilter.Config())))
                        .uri("http://domaininfo-service/domain"))

                .route("domaincreate", r -> r.path("/domain/**")
                        .and().method("POST")
                        .filters(f -> f.filter(routeCounterFilter.apply(new RouteCounterFilter.Config())))
                        .uri("http://domaincreate-service/domain"))

                .route("domaindelete", r -> r.path("/domain/**")
                        .and().method("DELETE")
                        .filters(f -> f.filter(routeCounterFilter.apply(new RouteCounterFilter.Config())))
                        .uri("http://domaindelete-service/domain"))

                .route("contactinfo", r -> r.path("/contact/**")
                        .and().method("GET")
                        .filters(f -> f.filter(routeCounterFilter.apply(new RouteCounterFilter.Config())))
                        .uri("http://contactinfo-service/contact"))

                .route("contactcreate", r -> r.path("/contact/**")
                        .and().method("POST")
                        .filters(f -> f.filter(routeCounterFilter.apply(new RouteCounterFilter.Config())))
                        .uri("http://contactcreate-service/contact"))

                .route("contactupdate", r -> r.path("/contact/**")
                        .and().method("PUT")
                        .filters(f -> f.filter(routeCounterFilter.apply(new RouteCounterFilter.Config())))
                        .uri("http://contactupdate-service/contact"))

                .route("contactdelete", r -> r.path("/contact/**")
                        .and().method("DELETE")
                        .filters(f -> f.filter(routeCounterFilter.apply(new RouteCounterFilter.Config())))
                        .uri("http://contactdelete-service/contact"))

                .route("hostinfo", r -> r.path("/host/**")
                        .and().method("GET")
                        .filters(f -> f.filter(routeCounterFilter.apply(new RouteCounterFilter.Config())))
                        .uri("http://hostinfo-service/host"))

                .route("hostcreate", r -> r.path("/host/**")
                        .and().method("POST")
                        .filters(f -> f.filter(routeCounterFilter.apply(new RouteCounterFilter.Config())))
                        .uri("http://hostcreate-service/host"))

                .route("hostupdate", r -> r.path("/host/**")
                        .and().method("PUT")
                        .filters(f -> f.filter(routeCounterFilter.apply(new RouteCounterFilter.Config())))
                        .uri("http://hostupdate-service/host"))

                .route("hostdelete", r -> r.path("/host/**")
                        .and().method("DELETE")
                        .filters(f -> f.filter(routeCounterFilter.apply(new RouteCounterFilter.Config())))
                        .uri("http://hostdelete-service/host"))

                .build();
    }

 */
}