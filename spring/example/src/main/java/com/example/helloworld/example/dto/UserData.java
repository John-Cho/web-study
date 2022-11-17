package com.example.helloworld.example.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    // 사용자 이름 (식별자)
    private String name;
    // 일기 내용을 담을 공간
    private ArrayList<Item> data;
}
