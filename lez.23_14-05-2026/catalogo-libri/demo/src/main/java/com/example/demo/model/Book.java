package com.example.demo.model;

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

    @Column(name = "title", nullable = false, length = 255)
    private String title;
    @Column(name = "author", nullable = false, length = 255)
    private String author;
    @Column(name = "pages", nullable = false, length = 255)
    private Integer pages;
    @Enumerated(EnumType.STRING) // salva il nome dell'enum come stringa ("TECH", "FICTION", "HISTORY")
    private Genre genre;

    // Costruttore no-arg
    protected Book() {
    }

    // Costruttore completo per uso applicativo
    public Book(String title, String author, Integer pages, Genre genre) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Il libro non può non avere un titolo");
        }
        if (author.isEmpty()) {
            throw new IllegalArgumentException("Deve esserci un autore");
        }
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

    //Override del metodo toString()
    @Override
    public String toString() {
        return "Run{id=" + id + ", title='" + title + "', author=" + author + ", pages=" + pages + ", genre=" + genre + "}";
    }
}
