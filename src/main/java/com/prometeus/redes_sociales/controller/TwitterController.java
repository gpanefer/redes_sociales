package com.prometeus.redes_sociales.controller;

import com.prometeus.redes_sociales.service.TwitterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/twitter")
public class TwitterController {

    @Autowired
    private final TwitterService twitterService;

    @GetMapping("/me")
    public ResponseEntity<String> getTwitterProfile() {
        String profile = twitterService.getTwitterProfile();
        return ResponseEntity.ok(profile);
    }
}
