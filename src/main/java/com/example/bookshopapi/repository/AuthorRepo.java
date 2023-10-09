package com.example.bookshopapi.repository;

import com.example.bookshopapi.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
    @Query("SELECT a FROM Author a WHERE MOD(a.id, 3) = 1")
    List<Author> findFamousAuthor();
    Author findById(int id);
}
