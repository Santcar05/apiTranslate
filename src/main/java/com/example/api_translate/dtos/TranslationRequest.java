package com.example.api_translate.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TranslationRequest {

    @NotBlank(message = "El texto a traducir es requerido")
    private String text;

    @NotBlank(message = "El idioma destino es requerido")
    private String targetLanguage;

    private String sourceLanguage = "auto"; // auto-detect

}
