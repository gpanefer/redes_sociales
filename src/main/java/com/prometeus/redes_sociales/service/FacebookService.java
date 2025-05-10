package com.prometeus.redes_sociales.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prometeus.redes_sociales.dto.FacebookResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@RequiredArgsConstructor
public class FacebookService {

    private final WebClient webClient;

    @Value("${facebook.api.token}")
    private String facebookToken;

    @Value("${facebook.api.url}")
    private String facebookApiUrl;

    public FacebookResponseDto getFacebookProfile() {
        String response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(facebookApiUrl)
                        .queryParam("fields", "id,name,email,picture")
                        .queryParam("access_token", facebookToken)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();


        return deserialize(response);
    }

    private FacebookResponseDto deserialize(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, FacebookResponseDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing Facebook response", e);
        }
    }
}
