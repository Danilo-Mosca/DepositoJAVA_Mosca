package com.example.libreria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.libreria.model.Book;
import com.example.libreria.model.Genre;

public interface BookRepository extends JpaRepository<Book, Integer> {
    // recupera tutti i libri
    List<Book>findAll();
    
    // metodo per recuperare un libro dal titolo
    List<Book> findByTitle(String title);

    // metodo per recuperare una lista di libri dal genere
    List<Book> findByGenre(Genre genre);

    // metodo per recuperare una lista dall'autore
    List<Book> findByAuthor(String author);

    // metodo per controllare se un libro esiste per id (usato nel delete di BookController)
    boolean existsById(int id);

    // metodo per controllare se un libro esiste per titolo
    boolean existsByTitle(String title);

    //recupera libri per numero pagine
    List<Book> findByPages(Integer pages);

    // JPQL: usa "Book" (nome classe) e "r.location" (nome campo Java)
    // @Query("SELECT r FROM Book r WHERE r.author = :author ORDER BY r.author ASC")
    // List<Book> findByAuthor(@Param("author") String author);
}