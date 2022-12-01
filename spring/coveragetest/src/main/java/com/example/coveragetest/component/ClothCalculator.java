package com.example.coveragetest.component;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClothCalculator implements ICalculator{
    private final SampleServer server;
    private int price;

    @Override
    public int totalPrice(int count) {
        initPrice();
        return count * price;
    }

    @Override
    public void initPrice() {
        this.price = server.init();
    }
}
