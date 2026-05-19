### Esercizio parte 1 - Capitolo 1: Architettura Controller → Service → Repository

**Obiettivo:** Eseguire il refactoring della tua `RunController` separando correttamente i
layer.

**Passi:**

1. Crea la classe `RunService` nel package `com.example.run` con annotazione `@Service`.
2. Sposta tutta la logica (ricerca per id, salvataggio, aggiornamento) da `RunController`
   a `RunService`.
3. Inietta `RunService` in `RunController` tramite costruttore.
4. Verifica che `RunController` non contenga più chiamate dirette a `RunRepository`.
5. Testa con Postman tutti gli endpoint (`GET`, `POST`, `PUT`, `DELETE`) e verifica che il
   comportamento sia invariato rispetto a prima del refactoring.

---

### Esercizio parte 2 - Capitolo 2: Validazione Input con Bean Validation

**Obiettivo:** Aggiungere vincoli di validazione al modello `Run` e verificarne il
comportamento.

**Passi:**

1. Aggiungi la dipendenza `spring-boot-starter-validation` al `pom.xml`.
2. Annota i campi dell'entità `Run` con i vincoli appropriati:
   - `title`: non vuoto, tra 3 e 100 caratteri.
   - `startedOn` e `completedOn`: non nulli.
   - `miles`: valore positivo, massimo 200.
   - `location`: non nulla.
3. Aggiungi `@Valid` ai metodi `create` e `update` del Controller.
4. Testa con Postman inviando richieste `POST` non valide (es. titolo vuoto, miglia negative)
   e verifica che la risposta sia `400 Bad Request`.
5. **(Bonus)** Implementa `BindingResult` per restituire una mappa degli errori strutturata.

---

### Esercizio parte 3 - Capitolo Gestione Errori Globale

**Obiettivo:** Implementare la gestione degli errori globale per il Run Tracker.

**Passi:**

1. Crea la classe `RunNotFoundException` che estende `RuntimeException`, con un messaggio
   che include l'id della corsa non trovata.
2. Modifica `RunService.findById()` per usare `orElseThrow()` lanciando
   `RunNotFoundException`.
3. Crea il record `ErrorResponse` con i campi `message`, `status` e `timestamp`.
4. Crea la classe `GlobalExceptionHandler` con `@ControllerAdvice` e i metodi:
   - Handler per `RunNotFoundException` → risposta `404`.
   - Handler generico per `Exception` → risposta `500`.
5. Testa con Postman:
   - `GET /api/runs/9999` — verifica risposta `404` con corpo JSON strutturato.
   - **(Bonus)** Prova a lanciare un'`IllegalArgumentException` nel Service e aggiungi
     il relativo handler.

---

### Esercizio parte 4 - Capitolo DTO — Data Transfer Object

**Obiettivo:** Introdurre i DTO nel Run Tracker e aggiornare il Controller e il Service.

**Passi:**

1. Crea il record `RunRequest` con i campi necessari in input (senza `id`) e le annotazioni
   di validazione.
2. Crea il record `RunResponse` con i campi da esporre al client.
3. Aggiorna `RunService`:
   - Il metodo `findAll()` restituisce `List<RunResponse>`.
   - Il metodo `findById()` restituisce `RunResponse`.
   - Il metodo `save()` accetta `RunRequest` e restituisce `RunResponse`.
   - Implementa i metodi privati `toEntity()` e `toResponse()` per il mapping.
4. Aggiorna `RunController` per usare `RunRequest` al posto di `Run` come `@RequestBody`.
5. Testa con Postman:
   - `GET /api/runs` — verifica che la risposta sia nella forma di `RunResponse`.
   - `POST /api/runs` — invia un `RunRequest` valido e verifica la risposta `201`.
   - `POST /api/runs` — invia un body senza `title` e verifica il `400 Bad Request`.

---