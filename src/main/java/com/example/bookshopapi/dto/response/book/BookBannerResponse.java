package com.example.bookshopapi.dto.response.book;

import com.example.bookshopapi.dto.objectdto.bookdto.BookBannerDto;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookBannerResponse {
    private int count;
    private List<BookBannerDto> products;
}
