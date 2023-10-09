package com.example.bookshopapi.service;

import com.example.bookshopapi.entity.WishList;
import com.example.bookshopapi.repository.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListService {
    @Autowired
    private WishListRepo wishListRepo;

    public WishList findByCustomerId(int customerId) {
        return wishListRepo.findByCustomerId(customerId);
    }

    public WishList save(WishList wishList) {
        return wishListRepo.save(wishList);
    }
}
