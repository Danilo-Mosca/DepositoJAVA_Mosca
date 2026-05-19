package com.example.demo.record;

import java.time.LocalDateTime;

import com.example.demo.model.Location;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

// Record immutabile: perfetto come DTO di input
public record RunRequest(
        @NotBlank 
        @Size(min = 3, max = 100, message = "Il titolo deve avere tra i 3 e i 100 caratteri") String title,

        @NotNull(message = "La data di inizio è obbligatoria") 
        LocalDateTime startedOn,

        @NotNull(message = "La data di fine è obbligatoria") 
        LocalDateTime completedOn,

        @Positive(message = "La distanza percorsa deve essere positiva non puoi aggiungere un valore negativo") 
        @Max(value = 50, message = "Non puoi inserire distanze superiori a 50 miglie") 
        double miles,

        @NotNull(message = "Devi inserire obbligatoriamente una location") 
        Location location) {
}