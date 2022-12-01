package com.example.coveragetest.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.coveragetest.component.ClothCalculator;
import com.example.coveragetest.component.SampleServer;
import com.example.coveragetest.dto.Req;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
@AutoConfigureWebMvc
@Import({ClothCalculator.class, SampleServer.class})
public class ApiControllerTest {
    @MockBean
    private SampleServer server;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void init(){
        Mockito.when(server.init()).thenReturn(10000);
    }

    @Test
    public void getTest() throws Exception{
        mockMvc.perform(
            MockMvcRequestBuilders.get("http://localhost:9090/api/get").queryParam("count", "10")
        ).andExpect(
            MockMvcResultMatchers.status().isOk()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.result").value(10000)
        ).andDo(
            MockMvcResultHandlers.print()
        );
    }

    @Test
    public void postTest() throws Exception{
        Req req = new Req();
        req.setCount(100);

        String json = new ObjectMapper().writeValueAsString(req);

        mockMvc.perform(
            MockMvcRequestBuilders.post("http://localhost:9090/api/post").contentType(MediaType.APPLICATION_JSON).content(json)
        ).andExpect(
            MockMvcResultMatchers.status().isOk()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.result").value(1000000)
        ).andDo(
            MockMvcResultHandlers.print()
        );
    }
}
