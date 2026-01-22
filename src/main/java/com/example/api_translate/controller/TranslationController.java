package com.example.api_translate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_translate.dtos.TranslationRequest;
import com.example.api_translate.dtos.TranslationResponse;
import com.example.api_translate.service.TranslationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/translate")
@CrossOrigin(origins = "*") // Allow requests from any origin (for development purposes)
public class TranslationController {

    @Autowired
    private TranslationService translationService;

    @PostMapping
    public ResponseEntity<TranslationResponse> translate(@Valid @RequestBody TranslationRequest request) {
        TranslationResponse response = translationService.translateText(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Translation API is running correctly");
    }
}
