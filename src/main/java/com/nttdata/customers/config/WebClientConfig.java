package com.nttdata.customers.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    private final WebClient.Builder webClientBuilder = WebClient.builder();
}
