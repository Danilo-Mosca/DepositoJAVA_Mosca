package com.example.libreria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 100)
    private String author;

    @Column(nullable = false)
    private Integer pages;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genre genre;

    // Costruttore no-arg
    protected Book() {
    }

    // Costruttore completo per uso applicativo
    public Book(String title, String author, Integer pages, Genre genre) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.genre = genre;
    }

    // Getter
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPages() {
        return pages;
    }

    public Genre getGenre() {
        return genre;
    }

    // Setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    // Override del metodo toString()
    @Override
    public String toString() {
        return "Run{id=" + id + ", title='" + title + "', author=" + author + ", pages=" + pages + ", genre=" + genre
                + "}";
    }
}