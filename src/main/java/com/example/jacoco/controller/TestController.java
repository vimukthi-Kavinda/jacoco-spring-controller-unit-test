package com.example.jacoco.controller;

import com.example.jacoco.dto.RequestDto;
import com.example.jacoco.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    private Logger logger = LoggerFactory.getLogger(TestController.class);


    @GetMapping("/get")
    public ResponseEntity<String> getTest(){
        logger.info("getTest() - calling");
        String res= testService.getTest();
        logger.info("getTest() - success");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> saveTest(@RequestBody RequestDto requestDto){
        logger.info("saveTest() - calling");
        testService.saveTest(requestDto);
        logger.info("saveTest() - success");
        return new ResponseEntity<>("Saved", HttpStatus.CREATED);
    }


}
