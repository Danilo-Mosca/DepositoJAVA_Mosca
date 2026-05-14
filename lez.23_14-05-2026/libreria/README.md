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