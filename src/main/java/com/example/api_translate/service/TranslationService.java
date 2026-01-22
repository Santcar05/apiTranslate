package com.example.api_translate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.api_translate.dtos.OpenRouterRequest;
import com.example.api_translate.dtos.TranslationRequest;
import com.example.api_translate.dtos.TranslationResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TranslationService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders openRouterHeaders;

    @Value("${openrouter.api.url}")
    private String apiUrl;

    @Value("${openrouter.model}")
    private String model;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public TranslationResponse translateText(TranslationRequest request) {
        try {
            // Prompt's construction
            String prompt = String.format(
                    "Translate the following text from %s to %s. Only return the translation, no explanations.\n\nText: %s",
                    request.getSourceLanguage(),
                    request.getTargetLanguage(),
                    request.getText()
            );

            // OpenRouter request construction
            OpenRouterRequest openRouterRequest = new OpenRouterRequest();
            openRouterRequest.setModel(model);

            OpenRouterRequest.Message message = new OpenRouterRequest.Message();
            message.setRole("user");
            message.setContent(prompt);
            openRouterRequest.getMessages().add(message);

            // OpenRouter API call
            HttpEntity<OpenRouterRequest> entity = new HttpEntity<>(openRouterRequest, openRouterHeaders);
            ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, entity, String.class);

            // Parse response
            JsonNode rootNode = objectMapper.readTree(response.getBody());
            String translatedText = rootNode
                    .path("choices")
                    .get(0)
                    .path("message")
                    .path("content")
                    .asText()
                    .trim();

            // Create and return TranslationResponse
            return new TranslationResponse(
                    request.getText(),
                    translatedText,
                    request.getSourceLanguage(),
                    request.getTargetLanguage(),
                    model
            );

        } catch (Exception e) {
            throw new RuntimeException("Error translating text: " + e.getMessage(), e);
        }
    }
}
