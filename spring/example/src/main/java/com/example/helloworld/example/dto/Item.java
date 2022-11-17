package com.example.helloworld.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    // 날짜
    private String date;
    // 제목
    private String title;
    // 글
    private String text;
}
