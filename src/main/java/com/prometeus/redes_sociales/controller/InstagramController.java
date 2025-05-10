package com.prometeus.redes_sociales.controller;

import com.prometeus.redes_sociales.service.InstagramService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/instagram")
public class InstagramController {

    @Autowired
    private final InstagramService instagramService;

    @GetMapping("/me")
    public ResponseEntity<String> getInstagramProfile() {
        String profile = instagramService.getInstagramProfile();
        return ResponseEntity.ok(profile);
    }
}
