package com.example.libreria.record;

import com.example.libreria.model.Genre;
import jakarta.validation.constraints.*;

// Record immutabile: perfetto come DTO di input
public record BookRequest(
        @NotNull(message = "Ci dev'essere un titolo") 
        @NotBlank(message = "Il titolo non può essere vuoto") 
        @Size(min = 3, max = 100, message = "Il titolo deve avere tra i 3 e i 100 caratteri") 
        String title,

        @NotNull(message = "Ci dev'essere un autore") 
        @NotBlank(message = "L'autore non può essere vuoto") 
        @Size(min = 3, max = 100, message = "L'autore deve avere un nome compreso tra i 3 e i 100 caratteri") 
        String author,

        @Positive(message = "Il numero delle pagine deve essere un valore maggiore di zero") 
        Integer pages,

        @NotNull(message = "Ci dev'essere un genere") 
        Genre genre) {
}