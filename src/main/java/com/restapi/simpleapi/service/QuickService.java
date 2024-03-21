package com.restapi.simpleapi.service;

import com.restapi.simpleapi.dto.*;
import com.restapi.simpleapi.mapper.QuickMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class QuickService {

    @Autowired
    private QuickMapper quickMapper;

    public boolean registerItem(itemDto itemDto) {
        log.info(" @@@ registerItem Service @@@ ");

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", itemDto.getId());
        paramMap.put("name", itemDto.getName());

        quickMapper.registerItem(paramMap);

        return true;
    }

    public itemDto getItemById(String id) {
        log.info(" @@@ getItem Service @@@ ");

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);

        HashMap<String, Object> responseMap = quickMapper.findById(paramMap);

        itemDto itemDto = new itemDto();
        itemDto.setId((String) responseMap.get("ID"));
        itemDto.setName((String) responseMap.get("NAME"));

        return itemDto;
    }
}
