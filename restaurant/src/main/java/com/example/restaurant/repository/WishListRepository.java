package com.example.restaurant.repository;

import com.example.restaurant.db.MemoryDbRepositoryAbstract;
import com.example.restaurant.wishlist.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository // db 저장하는 곳임
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {

}
