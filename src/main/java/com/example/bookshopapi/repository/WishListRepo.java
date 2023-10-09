package com.example.bookshopapi.repository;

import com.example.bookshopapi.entity.Customer;
import com.example.bookshopapi.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepo extends JpaRepository<WishList, Integer> {
    WishList findByCustomerId(int customerId);

//    WishList save(WishList wishList);
}
