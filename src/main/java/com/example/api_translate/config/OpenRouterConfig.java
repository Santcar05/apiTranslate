package com.example.api_translate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenRouterConfig {

    // Use the API key from environment variable
    @Value("${openrouter.api.key}")
    private String apiKey;

    // 
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders openRouterHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");
        headers.set("HTTP-Referer", "http://localhost:8080");
        headers.set("X-Title", "Translation API");
        return headers;
    }
}
