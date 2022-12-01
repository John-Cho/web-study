package com.example.coveragetest.component;

import org.assertj.core.matcher.AssertionMatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import({SampleServer.class, ClothCalculator.class})
public class CalculatorTest {
    @MockBean
    private SampleServer sampleServer;

    @Autowired
    private ClothCalculator clothCalculator;

    @BeforeEach
    public void init(){
        Mockito.when(sampleServer.init()).thenReturn(1000);
    }

    @Test
    public void Test(){
        clothCalculator.initPrice();
        
        int total = clothCalculator.totalPrice(100);

        Assertions.assertEquals(100000, total);
    }
}
