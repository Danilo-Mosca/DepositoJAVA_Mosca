# ESERCIZIO: Gestione di una Piattaforma di Notifiche Personalizzabili
Descrizione generale:
In un gruppo di lavoro, progettate un’applicazione Java che simuli una piattaforma in cui utenti ricevono notifiche da una sorgente centrale, e possono personalizzarne il contenuto o la forma. L’applicazione deve integrare tre design pattern obbligatori: Singleton, Decorator, Observer.

Obiettivo didattico:
- Comprendere e applicare design pattern reali in un sistema coeso
- Lavorare in gruppo su componenti modulari
- Usare Java in modo avanzato con progettazione orientata agli oggetti

Requisiti obbligatori:
    1. Pattern Singleton – Gestore Notifiche Unico
Create una classe NotificationManager che:
- È una Singleton
- Rappresenta la sorgente centrale da cui partono le notifiche
- Contiene un metodo inviaNotifica(String messaggio)

    2. Pattern Observer – Utenti che ricevono notifiche
Ogni utente è un oggetto che:
- Implementa un’interfaccia Observer
- Si registra a NotificationManager
- Riceve il messaggio e lo stampa sul terminale
- Deve poter essere aggiunto e rimosso dinamicamente

    3. Pattern Decorator – Person alizzazione delle notifiche
Create decoratori per modificare il messaggio prima della stampa da parte dell’utente:
- Aggiunta di timestamp
- Conversione in maiuscolo/minuscolo
- Aggiunta di emoji o prefissi

Ogni utente può essere decorato in modo diverso.

Esempio funzionale atteso:
- Il NotificationManager invia “Sistema in manutenzione”
- L’utente 1 stampa: [2025-07-09 10:30] SISTEMA IN MANUTENZIONE
- L’utente 2 stampa: Notifica: Sistema in manutenzione
- L’utente 3 non è più iscritto e non riceve nulla

<br/>
<br/>
<br/>

# Struttura delle classi nella piattaforma:

- Subject: interfaccia dei Subject: osservati
- NotificationManager: classe sia Singleton (che può essere istanziata una sola volta) che Subject (osservato) degli Observer perchè implementa l'interfaccia Supject (dell'osservato)
- Observer: interfaccia degli Observer (osservante)
- Utente: implementa Observer: classe concreta di Observer (è la classe concreta degli osservatori)

- Message: interfaccia del decoratore
- MessageBaseDecorator: classe concreta dell'interfaccia Message
- MessageDecorator: classe astratta che implementa l'interfaccia base Message
  - TimestampDecorator: classe concreta che estende la classe astratta MessageDecorator e implementa il messaggio con l'aggiunta dell'orario corrente
  - UppercaseDecorator: classe concreta che estende la classe astratta MessageDecorator e implementa il messaggio tutto in maiuscolo
  - EmojiDecorator: classe concreta che estende la classe astratta MessageDecorator e implementa il messaggio con l'aggiunta delle emoji

- Main: classe entrypoint del progetto
