package com.example.libreria.record;

import com.example.libreria.model.Genre;

public record BookResponse(
        Integer id,
        String title,
        String author,
        Integer pages,
        // String invece di enum: più leggibile per il client
        String genre) {
}