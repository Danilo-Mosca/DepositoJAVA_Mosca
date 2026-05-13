## 5. Esercizio — RunController Completo. Esercizio n.2 del 13/05/2026

### Obiettivo

Costruire un `RunController` completo che gestisca una lista di oggetti `Run` in memoria, utilizzando il Record Java definito al Giorno 3. L'esercizio integra tutto ciò che è stato visto nel Giorno 4.

---

### Setup — Il Record Run

Prima di tutto, assicurati di avere il Record `Run` (definito al Giorno 3) nel tuo progetto:

```java
// src/main/java/com/example/demo/model/Run.java
package com.example.demo.model;

import java.time.LocalDateTime;

public record Run(
    Integer id,
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedOn,
    Double miles,
    Location location
) {
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
```

```java
// src/main/java/com/example/demo/model/Location.java
package com.example.demo.model;

public enum Location {
    INDOOR,
    OUTDOOR
}
```

---

### Il Controller da Implementare

```java
// src/main/java/com/example/demo/controller/RunController.java
package com.example.demo.controller;

import com.example.demo.model.Run;
import com.example.demo.model.Location;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    // Lista in memoria (simula un database)
    private final List<Run> runs = new ArrayList<>();

    // Dati iniziali caricati nel costruttore
    public RunController() {
        
    }

    // GET /api/runs → lista di tutte le corse
    @GetMapping
    public ResponseEntity<List<Run>> findAll() {
        
    }

    // GET /api/runs/{id} → singola corsa per ID
    @GetMapping("/{id}")
    public ResponseEntity<Run> findById(@PathVariable Integer id) {
       
    }

    // POST /api/runs → crea una nuova corsa
    @PostMapping
    public ResponseEntity<Run> create(@RequestBody Run newRun) {
        
    }

    // PUT /api/runs/{id} → aggiorna una corsa esistente
    @PutMapping("/{id}")
    public ResponseEntity<Run> update(@PathVariable Integer id, @RequestBody Run updatedRun) {
        
    }

    // DELETE /api/runs/{id} → elimina una corsa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        
    }
}
```

---

### Punti chiave da verificare

Prima di testare con Postman, controlla che:

1. L'applicazione sia in esecuzione (`./mvnw spring-boot:run`)
2. La porta predefinita sia `8080` (verificalo in `application.properties`)
3. Non ci siano errori in console al momento dell'avvio

---

### Test con Postman — Sequenza Consigliata

Esegui i test in questo ordine per verificare tutti gli endpoint:

**Step 1 — Leggi la lista iniziale**

```
GET http://localhost:8080/api/runs
→ Atteso: 200 OK, array con 2 corse
```

**Step 2 — Cerca per ID**

```
GET http://localhost:8080/api/runs/1
→ Atteso: 200 OK, oggetto Run con id=1

GET http://localhost:8080/api/runs/99
→ Atteso: 404 Not Found
```

**Step 3 — Crea una nuova corsa**

```
POST http://localhost:8080/api/runs
Content-Type: application/json

{
  "id": 3,
  "title": "Weekend Long Run",
  "startedOn": "2024-05-04T08:00:00",
  "completedOn": "2024-05-04T09:30:00",
  "miles": 10.5,
  "location": "OUTDOOR"
}
→ Atteso: 201 Created con l'oggetto appena creato
```

**Step 4 — Verifica l'inserimento**

```
GET http://localhost:8080/api/runs
→ Atteso: 200 OK, array con 3 corse
```

**Step 5 — Elimina una corsa**

```
DELETE http://localhost:8080/api/runs/2
→ Atteso: 204 No Content

DELETE http://localhost:8080/api/runs/99
→ Atteso: 404 Not Found
```

**Step 6 — Verifica l'eliminazione**

```
GET http://localhost:8080/api/runs
→ Atteso: 200 OK, array con 2 corse (id=1 e id=3)
```

---
