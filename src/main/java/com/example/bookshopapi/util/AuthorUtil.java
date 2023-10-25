package com.example.bookshopapi.util;


import com.example.bookshopapi.dto.request.AuthorRequest;
import com.example.bookshopapi.entity.Author;

public class AuthorUtil {
    public Author addAuthor(AuthorRequest authorRequest){
        Author author=new Author();
        author.setName(authorRequest.getName());
        author.setDescription(authorRequest.getDescription());
        return author;
    }
}
