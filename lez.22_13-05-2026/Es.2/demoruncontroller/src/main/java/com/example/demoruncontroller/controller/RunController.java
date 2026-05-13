package com.example.demoruncontroller.controller;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoruncontroller.run.Run;
import com.example.demoruncontroller.run.Location;

@RestController
@RequestMapping("api/runs")
public class RunController {

    // Lista in memoria (simula un database)
    private final List<Run> runs = new ArrayList<>(
            List.of(new Run(1, "Corsa mattutina", LocalDateTime.of(2026, 5, 13, 8, 00),
                    LocalDateTime.of(2026, 5, 13, 10, 30), 5.0, Location.OUTDOOR),

                    new Run(1, "Corsa pomeridiala", LocalDateTime.of(2026, 5, 13, 18, 00),
                            LocalDateTime.of(2026, 5, 13, 19, 00), 3.0, Location.INDOOR),

                    new Run(1, "Corsa serale", LocalDateTime.of(2026, 5, 13, 21, 00),
                            LocalDateTime.of(2026, 5, 13, 22, 30), 2.0, Location.OUTDOOR))

    );

    // Dati iniziali caricati nel costruttore
    public RunController() {

    }

    // GET /api/runs → lista di tutte le corse
    @GetMapping
    public ResponseEntity<List<Run>> findAll() {
        return ResponseEntity.ok(runs);
    }

    // GET /api/runs/{id} → singola corsa per ID
    @GetMapping("/{id}")
    public ResponseEntity<Run> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(runs.get(id));

    }

    // POST /api/runs → crea una nuova corsa
    @PostMapping
    public ResponseEntity<Run> create(@RequestBody Run newRun) {
        runs.add(newRun);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRun);
    }

    // PUT /api/runs/{id} → aggiorna una corsa esistente
    @PutMapping("/{id}")
    public ResponseEntity<Run> update(@PathVariable Integer id, @RequestBody Run updatedRun) {
        runs.set(id, updatedRun);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedRun);
    }

    // DELETE /api/runs/{id} → elimina una corsa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if(id <0 || id >= runs.size()){
            return ResponseEntity.notFound().build();
        }
        runs.remove(id);
        return ResponseEntity.noContent().build();

    }
}