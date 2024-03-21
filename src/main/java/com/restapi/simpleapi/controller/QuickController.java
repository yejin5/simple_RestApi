package com.restapi.simpleapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuickController {

    @GetMapping("/dummy")
    public String dummy() {
        return "{}";
    }

}
