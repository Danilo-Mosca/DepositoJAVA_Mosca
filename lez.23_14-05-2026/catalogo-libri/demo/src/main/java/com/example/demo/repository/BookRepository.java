package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Book;
import com.example.demo.model.Genre;


public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByTitle(String title);

    List<Book> findByPages(Integer pages);

    List<Book> findByGenre(Genre genre);  

    Optional<Book> findFirstByTitle(String title);
    boolean existsByTitle(String title);

    // JPQL: usa "Book" (nome classe) e "r.location" (nome campo Java)
    @Query("SELECT r FROM Book r WHERE r.author = :author ORDER BY r.author ASC")
    List<Book> findByAuthor(@Param("author") String author);
}
