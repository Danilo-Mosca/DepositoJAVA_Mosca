# Esercizio Java "Ticket"

Andiamo a creare un sistema che permetta di gestire l'inserimento di tichet di richieste che possono essere gestiti in CRUD. 
Inoltre ci deve essere un utente che può inserire e vedere, e un admin che può solo modificare ed eliminare oltrechè risolvere i ricket, 
è obbligatorio usare un pattern architetturale MVC e un pattern per tipo: comportamentale, strutturale e creazionale. 

I pattern che abbiamo visto a lezione sono i seguenti: 
- Strutturali:
    - decorator
    - facade 

- Creazionale: 
    - singleton
    - strategy 

- Comportamentali: 
    - Observer

## Struttura del progetto

    src/
     ├── model/
     │    ├── Ticket.java
     │    ├── User.java
     │
     ├── controller/
     │    ├── TicketController.java
     │    ├── TicketRepository.java
     │    ├── TicketService.java
     │    ├── TicketFacade.java
     │    ├── Observer.java
     │    ├── UserObserver.java
     │    ├── AdminObserver.java
     │
     └── view/
          ├── ConsoleView.java
          └── MainApp.java

------------------------------------------------------------------------

## 📌 Descrizione del progetto

Questo progetto è un sistema di gestione ticket sviluppato in Java
seguendo l'architettura MVC.

Il sistema permette: - Login di utenti con ruolo USER o ADMIN -
Creazione ticket - Visualizzazione ticket - Risoluzione ticket (solo
ADMIN) - Eliminazione ticket (solo ADMIN)

L'interazione avviene tramite console con menu testuale.

------------------------------------------------------------------------

## 🏗️ Architettura utilizzata (MVC)

### 📂 Model

Contiene le entità del dominio: - Ticket - User

### 🎮 Controller

Gestisce la logica applicativa e le operazioni sui dati: -
TicketController - TicketRepository - TicketFacade - TicketService

### 🖥️ View

Gestisce input/output utente: - ConsoleView - MainApp

------------------------------------------------------------------------

## 🧩 Design Pattern utilizzati

### 🔹 Singleton

Utilizzato in: - TicketRepository

Permette di avere una sola istanza globale del repository.

------------------------------------------------------------------------

### 🔹 Facade

Utilizzato in: - TicketFacade

Semplifica l'accesso alle operazioni del sistema ticket.

------------------------------------------------------------------------

### 🔹 Observer

Utilizzato in: - TicketService (Subject) - UserObserver - AdminObserver

Permette di notificare automaticamente gli utenti agli eventi del
sistema.

------------------------------------------------------------------------

### 🔹 Strategy (concettuale)

Utilizzato per la gestione dei permessi USER / ADMIN tramite controllo
logico nel controller.

------------------------------------------------------------------------

### 🔹 MVC (architettura principale)

Separazione in: - Model - View - Controller

Permette una chiara divisione delle responsabilità.

------------------------------------------------------------------------

## 🚀 Conclusione

Il progetto combina architettura MVC con più design pattern per
garantire: - modularità - scalabilità - separazione delle responsabilità
