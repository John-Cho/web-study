package com.example.restaurant.naver.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchLocalRes {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<SearchLocalItem> items;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchLocalItem{
        private String title;
        private String link;
        private String category;
        private String description;
        private String telephone;
        private String address;
        private String roadAddress;
        private String mapx;
        private String mapy;

    }
}
