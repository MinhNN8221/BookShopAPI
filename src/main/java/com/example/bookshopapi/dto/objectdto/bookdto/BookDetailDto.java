package com.example.bookshopapi.dto.objectdto.bookdto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDetailDto {
    private int product_id;
    private String name;
    private String description;
    private String price;
    private String discounted_price;
    private int quantity;
    private int quantitySold;
    private String thumbnail;
    private int wishlist;
}
