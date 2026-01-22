package com.example.api_translate.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TranslationResponse {

    private String originalText;
    private String translatedText;
    private String sourceLanguage;
    private String targetLanguage;
    private String modelUsed;
}
