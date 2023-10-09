package com.example.bookshopapi.dto.response.book;

import com.example.bookshopapi.dto.objectdto.bookdto.BookDto;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookResponse {
    private int count;
    private List<BookDto> rows;
}
