package com.example.demo.record;

import java.time.LocalDateTime;

// Espone solo i campi che il client deve vedere
public record RunResponse(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        double miles,
        String location // String invece di enum: più leggibile per il client
) {
}
