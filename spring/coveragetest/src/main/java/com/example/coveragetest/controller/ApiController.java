package com.example.coveragetest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.coveragetest.component.ICalculator;
import com.example.coveragetest.dto.Req;
import com.example.coveragetest.dto.Rsp;
import com.example.coveragetest.dto.Rsp.Body;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private final ICalculator calc;

    @GetMapping("/get")
    public Rsp get(@RequestParam int count){
        Rsp rsp = new Rsp();
        int total = calc.totalPrice(count);
        rsp.setResult(String.valueOf(total));
        rsp.setBody(new Rsp.Body(200));

        return rsp; 
    }

    @PostMapping("/post")
    public Rsp post(@RequestBody Req req){
        Rsp rsp = new Rsp();
        int total = calc.totalPrice(req.getCount());
        rsp.setResult(String.valueOf(total));
        rsp.setBody(new Body(200));

        return rsp;
    }
}
