package com.example.jacoco.service.impl;

import com.example.jacoco.dto.RequestDto;
import com.example.jacoco.dto.ResponseDto;
import com.example.jacoco.service.TestService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    private Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

    @Override
    public String getTest() {
        ResponseDto res = new ResponseDto();
        res.setId(10);
        res.setName("vk");
        res.setAddress("addr");
        return new Gson().toJson(res);
    }

    @Override
    public void saveTest(RequestDto requestDto) {
        String jsonReq = new Gson().toJson(requestDto);
        log.info("------------------ SAVING REQUEST-------------------");
        log.info("request : {}",jsonReq);
        log.info("------------------ SAVED -------------------");
    }
}
