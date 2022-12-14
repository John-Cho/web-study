package com.example.restaurant.wishlist.entity;

import java.time.LocalDateTime;

import com.example.restaurant.db.MemoryDbEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishListEntity extends MemoryDbEntity{
    private String titile;                  // 음식명,
    private String category;                // 카테고리
    private String address;                 // 주소명
    private String roadAddress;             // 도로명 주소
    private String homePageLink;            // 홈페이지주소
    private String imageLink;               // 이미지 주소
    private Boolean isVisit;                // 방문여부
    private int visitCount;                 // 방문 횟수
    private LocalDateTime lastVisitDate;    // 마지막 방문 일자
}
