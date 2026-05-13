package com.example.demoruncontroller.run;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Double miles,
        Location location) {
    // Validazione nel costruttore canonico
    public Run {
        if (miles != null && miles < 0) {
            throw new IllegalArgumentException("I chilometri non possono essere negativi");
        }
        if (completedOn != null && startedOn != null && completedOn.isBefore(startedOn)) {
            throw new IllegalArgumentException("La data di fine non può precedere quella di inizio");
        }
    }
}
