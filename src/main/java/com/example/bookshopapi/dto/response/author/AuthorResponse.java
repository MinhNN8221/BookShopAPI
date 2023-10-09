package com.example.bookshopapi.dto.response.author;

import com.example.bookshopapi.entity.Author;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorResponse {
    private List<Author> authors;
}
