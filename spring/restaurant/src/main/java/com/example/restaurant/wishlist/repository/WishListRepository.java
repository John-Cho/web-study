package com.example.restaurant.wishlist.repository;

import org.springframework.stereotype.Component;

import com.example.restaurant.db.MemoryDbRepositoryAbstract;
import com.example.restaurant.wishlist.entity.WishListEntity;

@Component
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity>{
    
}
