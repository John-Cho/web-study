package com.example.helloworld.example.controller;

import java.util.HashMap;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.example.dto.Item;
import com.example.helloworld.example.dto.UserData;
import com.example.helloworld.example.service.ReportService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

    /* Service Class */
    private final ReportService rService;
    public ApiController(ReportService reportService){
        this.rService = reportService;
    }

    /* Get Method */
    @GetMapping("/get/{name}")
    public ResponseEntity get(@PathVariable String name){
        log.info("Request GET Method : who ({})", name);
        UserData userData = rService.getUserData(name);
        if(userData != null){
            log.info("Get User Data : {}", userData.toString());
            return ResponseEntity.status(HttpStatus.OK).body(userData);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /* Post Method */
    @PostMapping("/post/{name}")
    public ResponseEntity post(@PathVariable String name, @RequestBody Item udata){
        log.info("Request Post Method : Who ({})", name);
        UserData userData = rService.setUserData(name, udata);
        log.info("Set Data : {}", userData.toString());
        return ResponseEntity.status(HttpStatus.OK).body(userData);
    }
}