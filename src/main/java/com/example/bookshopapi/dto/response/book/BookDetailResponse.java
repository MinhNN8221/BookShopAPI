package com.example.bookshopapi.dto.response.book;

import com.example.bookshopapi.dto.objectdto.authordto.AuthorDto;
import com.example.bookshopapi.dto.objectdto.bookdto.BookDetailDto;
import com.example.bookshopapi.dto.objectdto.supplierdto.SupplierDto;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDetailResponse {
    private BookDetailDto product;
    private SupplierDto supplier;
    private AuthorDto author;
}
