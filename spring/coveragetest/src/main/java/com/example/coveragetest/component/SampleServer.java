package com.example.coveragetest.component;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Component
@RequiredArgsConstructor
public class SampleServer {
    private int price = 1000;

    public SampleServer(int price){
        this.price = price;
    }

    public int init(){
        return this.price;
    }
}
