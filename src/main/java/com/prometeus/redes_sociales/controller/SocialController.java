package com.prometeus.redes_sociales.controller;

import com.prometeus.redes_sociales.service.FacebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/social")
public class SocialController {

    @Autowired
    private FacebookService facebookService;

    @GetMapping("/facebook/test")
    public String testFacebook() {
        return facebookService.test();
    }
}
