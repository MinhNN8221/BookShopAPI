package com.example.bookshopapi.dto.response.book;

import com.example.bookshopapi.dto.objectdto.bookdto.BookHotNewDto;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookHotNewResponse {
    private int count;
    private List<BookHotNewDto> products;
}
