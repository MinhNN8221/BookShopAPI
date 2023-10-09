package com.example.bookshopapi.dto.response.author;

import com.example.bookshopapi.entity.Author;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorInfoResponse {
    private Author result;
}
