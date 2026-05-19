## 4. Esercizio — CRUD Completo con DB

### Obiettivo

Realizzare un piccolo **catalogo libri** persistente su database H2, implementando tutti e quattro gli endpoint CRUD, testandoli con Postman e verificando la persistenza tramite H2 Console.

---

### Prerequisiti

- Progetto Spring Boot funzionante con un controller REST di base
- Maven configurato con Spring Web già presente

---

### Step 1 — Aggiungere le dipendenze JPA e H2

Apri `pom.xml` e aggiungi, all'interno della sezione `<dependencies>`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

Salva e lascia che Maven scarichi le dipendenze (IntelliJ: clicca sul popup **Load Maven Changes**; VS Code: attendi il build automatico).

---

### Step 2 — Configurare `application.properties`

Sostituisci il contenuto di `src/main/resources/application.properties` con:

```properties
spring.application.name=demo

server.port=8080

spring.datasource.url=jdbc:h2:mem:librarydb
spring.datasource.driver-class-name=org.h2.Driver

spring.datasource.username=sa
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true

spring.jpa.properties.hibernate.format_sql=true
spring.jpa.defer-datasource-initialization=true

spring.sql.init.mode=always
spring.sql.init.data-locations=classpath:data.sql

spring.h2.console.enabled=true
```

---

### Step 3 — Creare `Book` come `@Entity`

Sostituisci il modello con una nuova entita `Book` (classe ordinaria, non record), ad esempio in `src/main/java/com/example/library/model/Book.java`:

- `@Entity` e `@Table(name = "books")`
- `@Id` e `@GeneratedValue(strategy = GenerationType.IDENTITY)` sul campo `id`
- `@Column` sui campi principali (`title`, `author`, `pages`)
- `@Enumerated(EnumType.STRING)` su un campo enum `genre` (es. `TECH`, `FICTION`, `HISTORY`)
- Costruttore no-arg `protected Book() {}`
- Costruttore completo con validazione
- Getter e setter per tutti i campi

---

### Step 4 — Creare `BookRepository`

Crea il file `src/main/java/com/example/library/repository/BookRepository.java` aggiungendo almeno 6 funzioni query a tua scelta e fantasia:

```java
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    // Spring genera l'implementazione automaticamente
}
```

---

### Step 5 — Crea `BookController`

Aggiorna (o crea) `BookController` scrivendo tutti gli EndPoint necessari (a tua discrezione)

---

### Step 6 — Creare `data.sql` con dati iniziali

Crea il file `src/main/resources/data.sql` e inseriscilo nella cartella resource (attento al file application.properties)

---

### Step 7 — Avviare e testare con Postman

Avvia l'applicazione con `./mvnw spring-boot:run` e verifica nella console che Hibernate abbia creato la tabella.

**Test 1 — GET /api/books (lista tutti i libri)**

- Metodo: `GET`
- URL: `http://localhost:8080/api/books`
- Risultato atteso: array JSON con i 2 libri del `data.sql`

**Test 2 — GET /api/books/{id} (singolo libro)**

- Metodo: `GET`
- URL: `http://localhost:8080/api/books/1`
- Risultato atteso: oggetto JSON con il primo libro
- Bonus: prova con un ID inesistente (es. `/api/books/999`) — dovresti ricevere `404 Not Found`

**Test 3 — POST /api/books (crea nuovo libro)**

- Metodo: `POST`
- URL: `http://localhost:8080/api/books`
- Header: `Content-Type: application/json`
- Body (JSON raw):

```json
{
    "title": "Effective Java",
    "author": "Joshua Bloch",
    "pages": 416,
    "genre": "TECH"
}
```

- Risultato atteso: `201 Created` con l'oggetto creato (campo `id` valorizzato dal DB)

**Test 4 — PUT /api/books/{id} (aggiorna)**

- Metodo: `PUT`
- URL: `http://localhost:8080/api/books/1`
- Header: `Content-Type: application/json`
- Body: stessa struttura del POST, con valori modificati (es. `"pages": 500`)
- Risultato atteso: `200 OK` con i dati aggiornati

**Test 5 — DELETE /api/books/{id} (elimina)**

- Metodo: `DELETE`
- URL: `http://localhost:8080/api/books/2`
- Risultato atteso: `204 No Content` (nessun body)
- Verifica: esegui GET /api/books — il libro con id 2 non deve più essere presente

---

### Step 8 — Verificare con H2 Console

1. Apri `http://localhost:8080/h2-console` nel browser
2. Connettiti con JDBC URL `jdbc:h2:mem:librarydb`, username `sa`, password vuota
3. Esegui:

```sql
SELECT * FROM books;
```

Verifica che le righe corrispondano allo stato attuale del database dopo le operazioni Postman.




# Giorno 6 
## Esercizio parte 1 - Capitolo 1: Architettura Controller → Service → Repository

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