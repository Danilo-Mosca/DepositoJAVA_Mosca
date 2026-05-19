package com.example.demo.exceptions;

// Estende RuntimeException: eccezione non verificata (unchecked)
public class RunNotFoundException extends RuntimeException {
    public RunNotFoundException(Integer id) {
        super("La corsa con id " + id + " non è stata trovata");
    }
}
