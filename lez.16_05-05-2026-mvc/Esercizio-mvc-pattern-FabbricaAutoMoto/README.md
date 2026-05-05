## Esercizio Archittetural Pattern
Esercizio: Fabbrica di Auto e Moto con MVC e Pattern

Progettare in Java un’applicazione console per la gestione di una fabbrica di veicoli, utilizzando il pattern architetturale MVC e integrando i pattern Singleton, Observer e Decorator. 

L’applicazione deve permettere di produrre veicoli, distinguendo tra auto e moto, visualizzare l’elenco dei veicoli prodotti e aggiornare lo stato della produzione.

Il sistema deve essere organizzato secondo MVC:
- Il Model deve rappresentare i veicoli prodotti e la fabbrica che li gestisce. 
- La View deve occuparsi esclusivamente della visualizzazione dei dati su console. 
- Il Controller deve ricevere le richieste dell’utente e coordinare le operazioni tra Model e View. 

Integrare i seguenti pattern:
- Singleton: la fabbrica deve essere un’unica istanza condivisa in tutta l’applicazione. 
- Observer: ogni volta che viene prodotto un nuovo veicolo, la View deve essere notificata automaticamente dell’aggiornamento. 
- Decorator: la descrizione dei veicoli deve poter essere arricchita con accessori o informazioni extra, ad esempio “con navigatore”, “con verniciatura sportiva” o “con pacchetto sicurezza”.


# Architettura generale:
- MVC
    - Model ('insieme delle seguenti classi):
        - Veicolo (interfaccia)
        - Auto (classe Auto base che implementa Veicolo)
        - Moto (classe Moto base che implementa Veicolo)
        - S_Fabbrica (Singleton + Subject per Observer) implementa anche l'interfaccia:
            - Subject
    - View:
        - ConsoleView (Observer) che a sua volta implementa l'interfaccia:
            - Observer
    - Controller:
        - FabbricaController (controller)

- Decoratori:
    - VeicoloDecorator (Decoratore base astratto che implementa l'interfaccia Veicolo)
        - Navigatore (decoratore concreto che estende la classe astratta decorator "VeicoloDecorator")
        - VerniciaturaSportiva (decoratore concreto che estende la classe astratta decorator "VeicoloDecorator")

- Main:
    - MainFabbrica (main/entrypoint del programma)
