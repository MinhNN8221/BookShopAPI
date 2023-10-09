package com.example.bookshopapi.service;

import com.example.bookshopapi.entity.Author;
import com.example.bookshopapi.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepo authorRepo;
    public List<Author> getFamousAuthor(){
        return authorRepo.findFamousAuthor();
    }
    public Author getAuthorInfo(int idAuthor){
        return authorRepo.findById(idAuthor);
    }
}
