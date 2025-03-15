package com.example.jacoco.controller;

import com.example.jacoco.dto.RequestDto;
import com.example.jacoco.service.TestService;
import com.google.gson.Gson;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = TestController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TestService testService;

    @Autowired
    private Gson gson;

    @Test
    public void TestController_getTest_returnJsonString()throws Exception{

        //BDDMockito.given(testService.getTest()).willAnswer(invocation->invocation.getArgument(0));
        BDDMockito.given(testService.getTest()).willReturn("{\"id\":10,\"name\":\"vk\",\"address\":\"Test address\"}");
        ResultActions res = mockMvc.perform(MockMvcRequestBuilders.get("/test/get")
                .contentType(MediaType.APPLICATION_JSON));

        res.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name",CoreMatchers.is("vk")));
    }

    @Test
    public void TestController_saveTest()throws Exception{

        //BDDMockito.given(testService.getTest()).willAnswer(invocation->invocation.getArgument(0));
        Mockito.doAnswer(invocation -> {
            RequestDto requestDto = invocation.getArgument(0);//arg obj
            System.out.println("Mocked saveTest called with requestDto: " + requestDto);
            return null;  // No return for void methods
        }).when(testService).saveTest(ArgumentMatchers.any());

        RequestDto requestDto = new RequestDto();
        requestDto.setAddress("Addr");
        requestDto.setName("vk");

        ResultActions res = mockMvc.perform(MockMvcRequestBuilders.post("/test")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(requestDto)));

        res.andExpect(MockMvcResultMatchers.status().isCreated());
    }



}
