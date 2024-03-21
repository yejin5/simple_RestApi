package com.restapi.simpleapi.controller;

import com.restapi.simpleapi.dto.*;
import com.restapi.simpleapi.service.QuickService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class QuickController {

    @Autowired
    private QuickService quickService;

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

    @PostMapping("/item")
    public responseDto registerItem(@RequestBody itemDto item) {
        log.info("item : {}", item);

        boolean isTrue = quickService.registerItem(item);
        if(isTrue) {
            responseDto responseDto = new responseDto();
            responseDto.setMessage("ok");
            return responseDto;
        } else {
            responseDto responseDto = new responseDto();
            responseDto.setMessage("fail");
            return responseDto;
        }
    }

}
