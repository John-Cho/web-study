package com.example.coveragetest.dto;

import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.StreamingHttpOutputMessage.Body;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rsp {
    private String result;
    private Body body;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Body{
        private int statuscode;
    }
}
