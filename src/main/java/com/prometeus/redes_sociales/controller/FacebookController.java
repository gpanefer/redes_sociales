package com.prometeus.redes_sociales.controller;

import com.prometeus.redes_sociales.dto.FacebookResponseDto;
import com.prometeus.redes_sociales.service.FacebookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/facebook")
public class FacebookController {


    private final FacebookService facebookService;

    @GetMapping("/me")
    public ResponseEntity<FacebookResponseDto> getFacebookProfile() {
        FacebookResponseDto profile = facebookService.getFacebookProfile();
        return ResponseEntity.ok(profile);
    }
}

