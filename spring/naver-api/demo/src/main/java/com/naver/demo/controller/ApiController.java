package com.naver.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naver.demo.service.RestTemplateSample;

@RestController
@RequestMapping("/api/client")
public class ApiController {

    private final RestTemplateSample rSample;
    
    // 의존성 주입을 받기 위해 생성자를 만들어주어야한다.
    public ApiController(RestTemplateSample rSample){
        this.rSample = rSample;
    }

    @GetMapping("/naver/{item}")
    public String getHello(@PathVariable String item){
        return rSample.GetNaverSearch(item);
    }
}
