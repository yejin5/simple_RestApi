package com.restapi.simpleapi.controller;

import com.restapi.simpleapi.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class QuickController {

    @GetMapping("/dummy")
    public String dummy() {
        log.info("dummy log");
        return "{}";
    }

    @GetMapping("/member")
    public String getMember(@RequestParam("empNo") String empNo) {
        log.info("empNo : {}", empNo);
        return "ok";
    }

    @GetMapping("/company/{id}")
    public String getCompany(@PathVariable("id") String id) {
        log.info("id : {}", id);
        return "ok";
    }

    // { "id" : "oooo", "name" : "ooo"}
    @PostMapping("/item")
    public responseDto registerItem(@RequestBody itemDto item) {
        log.info("item : {}", item);
        responseDto responseDto = new responseDto();
        responseDto.setMessage("ok");
        return responseDto;
    }

}
