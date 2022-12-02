package com.example.swagger.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger.dto.UserReq;
import com.example.swagger.dto.UserRes;

import ch.qos.logback.classic.turbo.TurboFilter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

@Api(tags = {"API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
public class ApiController {
    
    // http://localhost:9090/swagger-ui/

    @GetMapping("/hello")
    public String get(){
        return "hello";
    }


    @ApiImplicitParams(
    {
        @ApiImplicitParam(name = "x", value = "x 값", required = true, dataType = "int"),
        @ApiImplicitParam(name = "y", value = "y 값", required = true, dataType = "int")
    }
    )
    @GetMapping("/plus/{x}")
    public int plus(@RequestParam int y, @PathVariable int x){
        return x+y;
    }

    @ApiResponse(code=1, message = "사용자의 나이가 10살 이하일 때")
    @ApiOperation(value = "사용자의 정보를 ECHO 하는 메소드 이빈다.")
    @GetMapping("/user")
    public UserRes user(UserReq userReq){
        return new UserRes(userReq.getName(), userReq.getAge());
    }
}
