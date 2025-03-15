package com.example.jacoco.service;

import com.example.jacoco.dto.RequestDto;

public interface TestService {
    String getTest();

    void saveTest(RequestDto requestDto);
}
