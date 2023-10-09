package com.example.bookshopapi.dto.objectdto.bookdto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookInCartDto {
    private int item_id;
    private String name;
    private String price;
    private int quantity;
    private int product_id;
    private String sub_total;
    private LocalDateTime added_on;
    private String discounted_price;
    private int wishlist;
    private String image;
}
