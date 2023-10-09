package com.example.bookshopapi.dto.response.cart;

import com.example.bookshopapi.dto.objectdto.bookdto.BookInCartDto;
import lombok.*;

import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartResponse {
    private String cart_id;
    private List<BookInCartDto> products;
}
