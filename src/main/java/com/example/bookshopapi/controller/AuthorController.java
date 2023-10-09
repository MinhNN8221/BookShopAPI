package com.example.bookshopapi.controller;

import com.example.bookshopapi.dto.response.author.AuthorInfoResponse;
import com.example.bookshopapi.dto.response.author.AuthorResponse;
import com.example.bookshopapi.entity.Author;
import com.example.bookshopapi.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/author")
@AllArgsConstructor
@Slf4j
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @GetMapping("/hot")
    public ResponseEntity<?> getFamousAuthor(){
        List<Author> authors=authorService.getFamousAuthor();
        AuthorResponse response=new AuthorResponse(authors);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{author_id}")
    public ResponseEntity<?> getAuthorInfo(@PathVariable int author_id){
        Author author=authorService.getAuthorInfo(author_id);
        AuthorInfoResponse response=new AuthorInfoResponse(author);
        return ResponseEntity.ok(response);
    }
}
