package com.example.api_translate.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenRouterRequest {

    private String model;
    private List<Message> messages = new ArrayList<>();
    private double temperature = 0.7;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Message {

        private String role;
        private String content;
    }
}
