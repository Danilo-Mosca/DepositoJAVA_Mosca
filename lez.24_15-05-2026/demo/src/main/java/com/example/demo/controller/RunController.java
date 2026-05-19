package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Run;
import com.example.demo.record.RunRequest;
import com.example.demo.record.RunResponse;
import com.example.demo.service.RunService;

import jakarta.validation.Valid;

// controller rest per gestire le corse
@RestController
// ora url dovrebbe essere stesso nome della tabella
@RequestMapping("/api/runs")
public class RunController {

    // niente più lista per simulare database ma usiamo runService
    private final RunService runService;

    // costruttore e injection di runService (iniettiamo la service runService dentro il controller così questo sarà in grado di chiamare la service (che a sua volta chiamerà la repository per eseguire le query)
    public RunController(RunService runService) {
        this.runService = runService;
    }

    // get generico
    // GET /api/runs → lista di tutte le corse
    @GetMapping         // get generico
    public ResponseEntity<List<RunResponse>> findAll() {
        List<RunResponse> runs = runService.findAll();
        
        return ResponseEntity.ok(runs);
    }

    // get singola corsa
    // GET /api/runs/{id} → singola corsa per ID
    @GetMapping("/{id}")
    public ResponseEntity<RunResponse> findById(@PathVariable Integer id) {
        RunResponse run = runService.findById(id);
        return ResponseEntity.ok(run);
    }

    // crea singola corsa
    // POST /api/runs → crea una nuova corsa
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody RunRequest run, BindingResult bindingResult) {
        //Codice senza BindingResult
        // Run saved = runService.save(run);
        // return ResponseEntity.status(201).body(runService.save(saved));
        
        //Codice con classe BindingResult per una gestione strutturata degli errori
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            System.out.println(errors);
            return ResponseEntity.badRequest().body(errors);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(runService.save(run));
    }

    // aggiorna una corsa
    // PUT /api/runs/{id} → aggiorna una corsa esistente
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody RunRequest runDetails, BindingResult bindingResult) {
       // Controllo errori validazione
        // CONTROLLO PRIMA DI TUTTO SE LA CLASSE HA INTERCETTATO DEGLI ERRORI DI VALIDAZIONE
        if (bindingResult.hasErrors()) {
            // Mi creo una Collection di tipo Map che associa una chiave ad un valore, in
            // questo caso String = chiave e la seconda String = valore
            Map<String, String> errors = new HashMap<>();
            // Ciclo con un forEach ed il metodo getFieldErrors() di bindingResult alla
            // ricerca degli errori e se questi sono presenti li aggiungo alla Map errors
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

            // Allora ritorno uno http status code error 400 bad request e nel body la map
            // contenente tutti gli errori rilevati da BindingResult
            return ResponseEntity.badRequest().body(errors);
        }
        // Se la classe non ha intercettato errori allora ritorno un http status code
        // 200 ok e richiamo il metodo del BookService per salvare il libro
        return ResponseEntity.status(HttpStatus.OK).body(runService.update(id, runDetails));
    }

    // elimina singola corsa
    // DELETE /api/runs/{id} → elimina una corsa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        runService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}