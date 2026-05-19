package com.example.libreria.exceptions;
import com.example.libreria.model.Genre;

// Estende RuntimeException: eccezione non verificata (unchecked)
public class BookGenreNotFoundException extends RuntimeException{
    
    public BookGenreNotFoundException(Genre genre) {
        super("Nessun libro trovato per il genere: " + genre);
    }
}
