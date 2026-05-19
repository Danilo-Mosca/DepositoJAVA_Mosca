package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.exceptions.RunNotFoundException;
import com.example.demo.model.Run;
import com.example.demo.record.RunRequest;
import com.example.demo.record.RunResponse;
import com.example.demo.repository.RunRepository;

import java.util.List;

@Service
public class RunService {

    private final RunRepository runRepository;  // dichiaro una variabile di tipo private final di RunRepository

    //Injection tramite costruttore (consigliata)
    public RunService(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    // GET /api/runs → lista di tutte le corse
    public List<RunResponse> findAll() {
        return runRepository.findAll()
                .stream()
                .map(this::toResponse) // converte ogni Run in RunResponse
                .toList();

        /*
         * IMPORTANTE: questa istruzione
         * .map(this::toResponse)
         * si chiama: method reference (riferimento a metodo)
         * è equivalente a questa
         * .map(run -> toResponse(run))
         * Infatti potevo scrivere anche
         * .stream()
         * .map(run -> toResponse(run))
         * .toList();
         */
    }

    // GET /api/runs/{id} → ricerca la singola Run per ID
    public RunResponse findById(Integer id) {
        // ricerca per id
        Run run = runRepository.findById(id)
                .orElseThrow(() -> new RunNotFoundException(id));
        return toResponse(run);
    }

    // POST /api/runs → crea una nuova Run
    public RunResponse save(RunRequest request) {
        //Controllo se esiste già una corsa con quel nome
        if(runRepository.existsByTitle(request.title())){
            throw new IllegalArgumentException(
                "Esiste già una corsa con nome: " + request.title());
        }
        // Converto RunRequest in Run
        Run run = toEntity(request); // converte RunRequest in Run
        // Salvo l'entità
        Run saved = runRepository.save(run);
        // Riconverto da Run a RunRequest per ritornarlo al controller
        return toResponse(saved); // restituisce RunResponse
    }

    // PUT /api/runs/{id} → aggiorna una run esistente
    public Run update(Integer id, RunRequest updatedRun) {
        //Controllo l'esistenza di quella riga nel database, se non la trova restituisce un errore richiamando la classe RunNotFoundException dal @ControllerAdvice di GlobalExceptionHandler
        Run run = runRepository.findById(id).orElseThrow(() -> new RunNotFoundException(id));
        
        //Se la Run esiste riempio i campi ricevuti dalla @RequestBody updatedRun
        run.setTitle(updatedRun.title());
        run.setStartedOn(updatedRun.startedOn());
        run.setCompletedOn(updatedRun.completedOn());
        run.setMiles(updatedRun.miles());
        run.setLocation(updatedRun.location());
        //Salvo nel database
        return runRepository.save(run);
    }

    // DELETE /api/runs/{id} → elimina una run
    public void deleteById(Integer id) {
        Run run = runRepository.findById(id).orElseThrow(() -> new RunNotFoundException(id));
        runRepository.deleteById(id);
    }



    // Mapping: RunRequest → Run (entità JPA)
    private Run toEntity(RunRequest request) {
        Run run = new Run(
        request.title(),
        request.startedOn(),
        request.completedOn(),
        request.miles(),
        request.location()
        );
        return run;
    }

    // Mapping: Run (entità JPA) → RunResponse
    private RunResponse toResponse(Run run) {
        return new RunResponse(
                run.getId(),
                run.getTitle(),
                run.getStartedOn(),
                run.getCompletedOn(),
                run.getMiles(),
                run.getLocation().name()
            );
    }
}