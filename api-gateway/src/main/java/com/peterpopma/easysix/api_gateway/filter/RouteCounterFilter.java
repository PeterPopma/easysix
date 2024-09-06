package com.peterpopma.easysix.api_gateway.filter;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class RouteCounterFilter extends AbstractGatewayFilterFactory<RouteCounterFilter.Config> {

    private final MeterRegistry meterRegistry;

    public RouteCounterFilter(MeterRegistry meterRegistry) {
        super(Config.class);
        this.meterRegistry = meterRegistry;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            Route route = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
            if (route != null) {
                String routeId = route.getId();

                // Increment counter
                Counter counter = meterRegistry.counter("gateway.routes.count", "routeId", routeId);
                counter.increment();

                // Start the timer
                Timer.Sample sample = Timer.start(meterRegistry);

                // Chain the filter and capture the response time when processing is finished
                return chain.filter(exchange).doFinally(signalType -> {
                    // Stop the timer and record the time
                    sample.stop(Timer.builder("gateway.routes.response.time")
                            .description("Time taken to process the request")
                            .tags("routeId", routeId)
                            .register(meterRegistry));
                });
            }

            return chain.filter(exchange);
        };
    }

    public static class Config {
        // Put any configuration properties here if needed
    }
}
