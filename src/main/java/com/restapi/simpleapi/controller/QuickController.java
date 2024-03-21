package com.restapi.simpleapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class QuickController {

    @GetMapping("/dummy")
    public String dummy() {
        log.info("dummy log");
        return "{}";
    }

}
