package com.example.libreria;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.libreria.exceptions.BookAuthorNotFoundException;
import com.example.libreria.exceptions.BookGenreNotFoundException;
import com.example.libreria.exceptions.BookNotFoundException;
import com.example.libreria.exceptions.BookTitleNotFoundException;
import com.example.libreria.record.ErrorResponse;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    //Gestisce BookNotFoundException restituendo un Not Found
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(BookNotFoundException exception){
        ErrorResponse error = new ErrorResponse(
            exception.getMessage(),
            HttpStatus.NOT_FOUND.value(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        //Oppure
        //return ResponseEntity.status(404).body(error);
    }

    //Titolo non trovato
    // Gestisce BookTitleNotFoundException restituendo un Not Found
    @ExceptionHandler(BookTitleNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTitleNotFound(BookTitleNotFoundException exception) {
        ErrorResponse error = new ErrorResponse(
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        // Oppure
        // return ResponseEntity.status(404).body(error);
    }

    //Autore non trovato
    // Gestisce BookAuthorNotFoundException restituendo un Not Found
    @ExceptionHandler(BookAuthorNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAuthorNotFound(BookAuthorNotFoundException exception) {
        ErrorResponse error = new ErrorResponse(
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        // Oppure
        // return ResponseEntity.status(404).body(error);
    }

    //Genere valido ma nessun libro presente per quel genere inserito
    // Gestisce BookGenreNotFoundException restituendo un Not Found
    @ExceptionHandler(BookGenreNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleGenreNotFound(BookGenreNotFoundException exception) {
        ErrorResponse error = new ErrorResponse(
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        // Oppure
        // return ResponseEntity.status(404).body(error);
    }

    //Genere non valido perchè input sbagliato, ovvero quando si inserisce un genere che non esiste nell'enum
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleEnumError() {

        ErrorResponse error = new ErrorResponse(
                "Genere non valido. Valori accettati: TECH, FICTION, HISTORY",
                400,
                java.time.LocalDateTime.now());

        return ResponseEntity.badRequest().body(error);
    }

    // Gestisce IllegalArgumentException → 400 Bad Request
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException exception) {
        ErrorResponse error = new ErrorResponse(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // Fallback: gestisce qualsiasi altra eccezione non prevista → 500 Internal
    // Server Error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception exception) {
        ErrorResponse error = new ErrorResponse(
                "Si è verificato un errore interno al server",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}