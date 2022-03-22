package com.example.restaurant.wishlist;

import com.example.restaurant.db.MemoryDbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WishListEntity extends MemoryDbEntity {

    private String title; // 음식명, 장소명
    private String category;
    private String address; // 주소
    private String loadAddress; // 도로명
    private String homePageLink;
    private String imageLink;
    private boolean isVisit; // 방문 여부
    private int visitCount; // 방문 카운트
    private LocalDateTime lastVisitDate; // 마지막 방문일자

}
