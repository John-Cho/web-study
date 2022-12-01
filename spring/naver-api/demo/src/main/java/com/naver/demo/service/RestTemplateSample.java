package com.naver.demo.service;

import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RestTemplateSample {
    public String GetNaverSearch(String subject){        
        URI uri = UriComponentsBuilder.fromUriString("https://openapi.naver.com")
        .path("/v1/search/local.json")
        .queryParam("display",5)
        .queryParam("query", subject)
        .encode(Charset.forName("UTF-8"))
        .build().toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri)
            .header("X-Naver-Client-Id", "m8pOvU17OhL4vJlCkB0P")
            .header("X-Naver-Client-Secret", "GSTzEqHUYp")
            .build();
        
            RestTemplate rTemplate = new RestTemplate();
            ResponseEntity<String> resp = rTemplate.exchange(requestEntity, String.class);
            return resp.getBody();
    }
}
