package com.prometeus.redes_sociales.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class InstagramService {

    private final WebClient webClient;

    @Value("${instagram.api.token}")
    private String instagramToken;

    @Value("${instagram.api.url}")
    private String instagramApiUrl;

    public String getInstagramProfile() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(instagramApiUrl)
                        .queryParam("fields", "id,username,account_type,media_count")
                        .queryParam("access_token", instagramToken)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
