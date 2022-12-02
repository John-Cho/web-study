package com.example.restaurant.naver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.restaurant.naver.dto.SearchLocalReq;

@SpringBootTest
public class NaverClientTest {
    
    @Autowired
    private NaverClient naverClient;

    @Test
    public void localSearchTest(){
        var search = new SearchLocalReq();
        search.setQuery("갈비집");

        var expect = naverClient.localSearch(search);
        System.out.println(expect.toString());
    }
}
