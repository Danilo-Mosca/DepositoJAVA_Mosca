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
        - Auto, Moto
        - Fabbrica (Singleton + Subject per Observer)
    - View:
        - ConsoleView (Observer)
    - Controller:
        - FabbricaController
