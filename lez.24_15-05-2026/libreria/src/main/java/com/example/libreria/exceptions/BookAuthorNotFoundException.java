package com.example.libreria.exceptions;

// Estende RuntimeException: eccezione non verificata (unchecked)
public class BookAuthorNotFoundException extends RuntimeException{
    
    public BookAuthorNotFoundException(String author) {
        super("Libro con autore " + author + " non trovato");
    }
}
