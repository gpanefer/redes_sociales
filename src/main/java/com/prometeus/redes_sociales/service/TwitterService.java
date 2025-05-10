package com.prometeus.redes_sociales.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class TwitterService {

    private final WebClient webClient;

    @Value("${twitter.api.token}")
    private String twitterToken;

    @Value("${twitter.api.url}")
    private String twitterApiUrl;

    public String getTwitterProfile() {
        return webClient.get()
                .uri(twitterApiUrl)
                .header("Authorization", "Bearer " + twitterToken)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
