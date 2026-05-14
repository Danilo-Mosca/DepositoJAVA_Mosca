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
    private final List<Run> runs = new ArrayList<>();

    // Old code:
    // private final List<Run> runs = new ArrayList<>(
    // List.of(new Run(1, "Corsa mattutina", LocalDateTime.of(2026, 5, 13, 8, 00),
    // LocalDateTime.of(2026, 5, 13, 10, 30), 5.0, Location.OUTDOOR),

    // new Run(2, "Corsa pomeridiana", LocalDateTime.of(2026, 5, 13, 18, 00),
    // LocalDateTime.of(2026, 5, 13, 19, 00), 3.0, Location.INDOOR),

    // new Run(3, "Corsa serale", LocalDateTime.of(2026, 5, 13, 21, 00),
    // LocalDateTime.of(2026, 5, 13, 22, 30), 2.0, Location.OUTDOOR)));

    // Dati iniziali caricati nel costruttore
    public RunController() {
        runs.add(new Run(1, "Corsa mattutina", LocalDateTime.of(2026, 5, 13, 8, 00),
                LocalDateTime.of(2026, 5, 13, 10, 30), 5.0, Location.OUTDOOR));

        runs.add(new Run(2, "Corsa pomeridiana", LocalDateTime.of(2026, 5, 13, 18, 00),
                LocalDateTime.of(2026, 5, 13, 19, 00), 3.0, Location.INDOOR));

        runs.add(new Run(3, "Corsa serale", LocalDateTime.of(2026, 5, 13, 21, 00),
                LocalDateTime.of(2026, 5, 13, 22, 30), 2.0, Location.OUTDOOR));
    }

    // GET /api/runs → lista di tutte le corse
    @GetMapping
    public ResponseEntity<List<Run>> findAll() {
        return ResponseEntity.ok(runs);
    }

    // GET /api/runs/{id} → singola corsa per ID
    @GetMapping("/{id}")
    public ResponseEntity<Run> findById(@PathVariable Integer id) {
        if (id < 0 || id >= runs.size()) {
            // Restituisco 404 Not Found senza body
            return ResponseEntity.notFound().build();
        }
        // Restituisce 200 Ok la corsa è stata trovata
        return ResponseEntity.ok(runs.get(id));

    }

    // POST /api/runs → crea una nuova corsa
    @PostMapping
    public ResponseEntity<Run> create(@RequestBody Run newRun) {
        runs.add(newRun);
        // Restituisce 201 Created con il prodotto appena creato
        return ResponseEntity.status(HttpStatus.CREATED).body(newRun);
    }

    // PUT /api/runs/{id} → aggiorna una corsa esistente
    @PutMapping("/{id}")
    public ResponseEntity<Run> update(@PathVariable Integer id, @RequestBody Run updatedRun) {
        // Se lo trovo nell'arrayList runs lo aggiorno
        for (int i = 0; i < runs.size(); i++) {
            if (runs.get(i).id().equals(id)) {
                runs.set(i, updatedRun);
                return ResponseEntity.ok(updatedRun);
            }
        }
        // Altrimenti invio un errore
        return ResponseEntity.notFound().build();
    }

    // DELETE /api/runs/{id} → elimina una corsa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        //Se l'id inserito esiste, elimino il campo
        if (id < 0 || id >= runs.size()) {
            return ResponseEntity.notFound().build();
        }
        runs.remove((int) id); // Devo fare il casting a intero primitivo altrimenti non funziona
        return ResponseEntity.noContent().build();

    }
}