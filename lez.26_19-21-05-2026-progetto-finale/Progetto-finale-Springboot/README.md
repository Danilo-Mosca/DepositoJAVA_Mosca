# 📚 Sistema di Gestione Libreria API (Spring Boot)

## Traccia 1 - Gestione Libreria: realizza una REST API con CRUD per i libri (titolo, autore, annoPubblicazione, disponibile). Aggiungi validazioni base e gestione errori con codici HTTP corretti.

## Descrizione Completa del Progetto
Questo progetto consiste nello sviluppo di un'API RESTful per la gestione completa di una libreria digitale, realizzata utilizzando il framework **Spring Boot** e il linguaggio **Java**. L'obiettivo principale dell'applicazione è fornire un sistema backend robusto e scalabile per la gestione di un catalogo di libri e degli utenti associati, permettendo l'automazione dei processi di inventario, prestito e restituzione dei volumi.

L'architettura del sistema è basata sul pattern **Controller-Service-Repository**, garantendo una netta separazione delle responsabilità. La persistenza dei dati è gestita tramite **Spring Data JPA** con un database **H2**, configurato per lavorare sia in memoria che su file locale per garantire la continuità dei dati tra i riavvii.

## Descrizione Dettagliata
Il progetto si articola su tre pilastri fondamentali:

1.  **Gestione del Catalogo Libri**: Ogni libro nel sistema è caratterizzato da titolo, autore, anno di pubblicazione, numero di pagine, genere e descrizione. Il sistema implementa validazioni rigorose sui dati in ingresso, come il controllo dell'anno di pubblicazione (che deve essere compreso tra il 1450 e l'anno corrente) e la lunghezza della descrizione.
2.  **Gestione degli Utenti**: L'applicazione permette di registrare nuovi utenti e monitorare lo storico dei loro prestiti. Ogni utente è identificato da nome e cognome e può essere associato a più libri contemporaneamente.
3.  **Logica di Prestito e Restituzione**: Questa è la funzione core del progetto. Quando un utente richiede un libro, il sistema verifica la disponibilità (flag `available`). Se disponibile, il libro viene assegnato all'utente e lo stato viene aggiornato a "non disponibile". La restituzione esegue l'operazione inversa, liberando il libro per futuri prestiti.
4.  **Validazione e Sicurezza dei Dati**: Grazie all'integrazione di **Jakarta Validation**, ogni richiesta in ingresso è filtrata per prevenire l'inserimento di dati errati o formati non validi (come stringhe al posto di numeri per l'anno). In caso di errore, un **Global Exception Handler** interviene per restituire all'utente dei messaggi di errore chiari e strutturati in formato JSON.

---

## Endpoint del Progetto

Di seguito sono elencati tutti gli endpoint disponibili nell'applicazione, suddivisi per categoria.

### 📖 Endpoint per i Libri (`/api/books`)

| Metodo | Endpoint | Descrizione |
| :--- | :--- | :--- |
| **GET** | `/api/books` | Ritorna la lista completa di tutti i libri presenti nel database. |
| **GET** | `/api/books/{id}` | Recupera le informazioni dettagliate di un singolo libro tramite il suo ID ID. |
| **POST** | `/api/books` | Crea e salva un nuovo libro nel catalogo (richiede validazione). |
| **PUT** | `/api/books/{id}` | Aggiorna le informazioni di un libro esistente identificato dall'ID. |
| **DELETE** | `/api/books/{id}` | Rimuove definitivamente un libro dal catalogo tramite il suo ID. |
| **GET** | `/api/books/titolo/{title}` | Ricerca un libro specifico filtrando per titolo (ignora maiuscole/minuscole). |
| **GET** | `/api/books/autore/{author}` | Filtra e ritorna la lista di tutti i libri appartenenti a un autore specifico. |
| **GET** | `/api/books/genere/{genre}` | Filtra e ritorna la lista di tutti i libri appartenenti a un genere specifico. |
| **GET** | `/api/books/search` | Ricerca avanzata tramite parametri query `author` (autore) e `title` (titolo). |

### 👥 Endpoint per gli Utenti (`/api/users`)

| Metodo | Endpoint | Descrizione |
| :--- | :--- | :--- |
| **GET** | `/api/users` | Recupera la lista di tutti gli utenti registrati e i libri loro associati. |
| **GET** | `/api/users/{id}` | Recupera i dettagli di un singolo utente tramite il suo ID. |
| **POST** | `/api/users` | Registra un nuovo utente nel sistema. |
| **PUT** | `/api/users/{id}` | Modifica i dati anagrafici (nome/cognome) di un utente esistente. |
| **DELETE** | `/api/users/{id}` | Elimina un utente dal sistema tramite il suo ID. |
| **GET** | `/api/users/nome/{name}` | Ricerca utenti filtrando per nome. |
| **GET** | `/api/users/cognome/{lastName}` | Ricerca utenti filtrando per cognome. |
| **GET** | `/api/users/search` | Ricerca avanzata tramite parametri query `name` (nome) e `lastName` (cognome). |
| **PUT** | `/api/users/{userId}/prestito/{bookId}` | **Operazione Prestito**: Associa il libro specificato all'utente e lo rende non disponibile. |
| **PUT** | `/api/users/{userId}/restituzione/{bookId}` | **Operazione Restituzione**: Rimuove l'associazione tra utente e libro e lo rende nuovamente disponibile. |

---

## 🛠️ Tecnologie Utilizzate
Il sistema è stato sviluppato utilizzando le seguenti tecnologie:
-   **Java 17/25**: Linguaggio di programmazione moderno per la logica di backend.
-   **Spring Boot**: Framework per la creazione rapida di applicazioni standalone di tipo enterprise.
-   **Spring Data JPA**: Per la gestione della persistenza e dell'interazione con il database tramite Hibernate.
-   **H2 Database**: Database SQL leggero e veloce, configurato con persistenza su file locale.
-   **Jakarta Validation**: Per l'implementazione di regole di validazione sui DTO e sulle entità.
-   **Maven**: Sistema di gestione delle dipendenze e automazione della build.

---

## 🚀 Guida all'Esecuzione (Step-by-Step)

Seguire questi passaggi per configurare ed eseguire il progetto localmente:

### 1. Prerequisiti
-   **Java JDK** 17 o superiore installato.
-   **Maven** installato (opzionale, poiché è incluso il wrapper `mvnw`).

### 2. Configurazione Iniziale
Clonare la repository o scaricare i file del progetto in una cartella locale.

### 3. Compilazione del Progetto
Aprire il terminale (o il prompt dei comandi) nella directory principale del progetto ed eseguire:
```bash
# Su Windows
mvnw.cmd clean install

# Su Linux / macOS
./mvnw clean install
```

### 4. Avvio dell'Applicazione
Una volta terminata la compilazione, avviare il server Spring Boot con il seguente comando:
```bash
# Su Windows
mvnw.cmd spring-boot:run

# Su Linux / macOS
./mvnw spring-boot:run
```

### 5. Verifica del Funzionamento
-   L'applicazione sarà accessibile all'indirizzo: `http://localhost:8080`
-   È possibile testare gli endpoint utilizzando strumenti come **Postman** o direttamente tramite browser per le richieste GET.
-   **Console H2**: Per visualizzare le tabelle del database in tempo reale, accedere a `http://localhost:8080/h2-console`.
    -   *URL JDBC*: `jdbc:h2:file:./h2-db/testdb`
    -   *Username*: `sa`
    -   *Password*: (lasciare vuoto)

---

## Membri del Team e Contributi
Il progetto è stato realizzato in collaborazione da:
-   **Anna Gloria**: Responsabile del Domain Model, dei Record Java (DTO) e delle logiche di validazione.
    
    - Model (Book, Genre, User): Progettazione dell'entità JPA Book e dell'enumerazione Genre per i generi letterari, impostando i vincoli di persistenza sul database (es. lunghezze dei campi e campi non nullabili).
    - Record / DTO (BookRequest, BookResponse, ErrorResponse, UserBookResponse, UserRequest, UserResponse): Creazione dei record Java immutabili per il trasferimento dei dati.
    - Validazione dei Dati: Implementazione dei vincoli Jakarta Validation nel record di richiesta (es. @NotBlank, @Size per il titolo e l'autore, e i limiti temporali per l'anno di pubblicazione)

-   **Danilo**: Sviluppatore della Business Logic (Service Layer), del Data Access Layer (Repository) e delle eccezioni core.
    - Business Logic (Service Layer): Implementazione della logica di business per le operazioni sui libri e sugli utenti, inclusa la gestione dei prestiti e delle restituzioni.
    - Data Access Layer (Repository): Implementazione dei repository per l'interazione con il database.
    - Eccezioni Core: Implementazione delle eccezioni personalizzate per la gestione degli errori.

-   **Giuseppe**: Sviluppatore dell'API Routing (Controller) e del sistema di gestione globale delle eccezioni.
    - API Routing (Controller): Implementazione dei controller per la gestione delle richieste API.
    - Sistema di Gestione Globale delle Eccezioni (GlobalExceptionHandler): Implementazione del sistema di gestione globale delle eccezioni.
    - Advanced Exceptions: Implementazione di eccezioni custom mirate, come BookYearNotFoundException, BookNotPrenotedException, e il supporto per gli errori granulari di validazione.