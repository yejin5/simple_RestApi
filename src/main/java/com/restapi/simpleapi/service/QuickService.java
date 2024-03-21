package com.restapi.simpleapi.service;

import com.restapi.simpleapi.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QuickService {

    public boolean registerItem(itemDto itemDto) {
        log.info(" @@@ registerItem Service @@@ ");

        return true;
    }
}
