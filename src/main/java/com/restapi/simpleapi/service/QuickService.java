package com.restapi.simpleapi.service;

import com.restapi.simpleapi.dto.*;
import com.restapi.simpleapi.entity.itemEntity;
import com.restapi.simpleapi.mapper.QuickMapper;
import com.restapi.simpleapi.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class QuickService {

    @Autowired
    private QuickMapper quickMapper;

    @Autowired
    private itemRepository itemRepository;

    public boolean registerItem(itemDto itemDto) {
        log.info(" @@@ registerItem Service @@@ ");

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", itemDto.getId());
        paramMap.put("name", itemDto.getName());

        quickMapper.registerItem(paramMap);

        return true;
    }

    public boolean registerItemJpa(itemDto itemDto) {
        log.info(" @@@ registerItem Service @@@ ");

        itemEntity itemEntity = new itemEntity();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());

        itemRepository.save(itemEntity);

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

    public itemDto getItemByIdJpa(String id) {
        log.info(" @@@ getItem Service @@@ ");

        itemEntity itemEntity = itemRepository.findById(id).get();
        itemDto itemDto = new itemDto();
        itemDto.setId(itemEntity.getId());
        itemDto.setName(itemEntity.getName());

        return itemDto;
    }
}
