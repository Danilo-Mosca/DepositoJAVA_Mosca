## ESERCIZIO con Architecthural pattern: MVC. Design pattern Facade + Strategy
Esercizio Medio:
Obiettivo: Simulare un sistema di avvio computer usando Facade.
Richiesta:
- Crea classi Bios, HardDisk, SistemaOperativo con metodi: inizializza(), carica(), avvia().
- Crea una classe ComputerFacade con metodo accendiComputer() che richiama i metodi appropriati in sequenza.
- In Main, istanzia il Facade e usa accendiComputer() per simulare l'avvio del PC.

Nell'esercizio oltre ad utilizzare il design pattern Facade usare anche il design pattern Strategy e il design architetturale MVC.


# Struttura del Progetto e Design Pattern Utilizzati

### Panoramica
Il progetto implementa:
- Pattern Architetturale MVC
- Design Pattern Facade
- Design Pattern Strategy

## Struttura MVC (Model - View - Controller)
Componenti:

- MODEL:
    - Classi base (componenti del computer):
        - **Bios**: inizializzazione del sistema
        - **HardDisk**: caricamento del sistema operativo
    
    - Strategy Pattern (parte del Model):
        - **SistemaOperativoStrategy**: interfaccia Strategy
        - **StrategyWindows**: Concrete Strategy
        - **StrategyMacOs**: Concrete Strategy
        - **StrategyLinux**: Concrete Strategy
        - **SistemaOperativoContext**: Context della Strategy

    - Facade (semplificazione del sistema)
        - **ComputerFacade**: coordina l’avvio del computer

- VIEW:
    - **ComputerView**: mostra messaggi all’utente tramite console

- CONTROLLER:
    - **ComputerController**: riceve input, in questo caso da console, coordina View e Model, avvia il processo tramite Facade

- Main: entrypoint del programma:
    - **Main**

## Design Pattern: STRATEGY
Componenti:

 - Strategy (interfaccia):
    - **SistemaOperativoStrategy**

 - Strategie cocrete:
    - **StrategyWindows**
    - **StrategyMacOs**
    - **StrategyLinux**

 - Context:
    - **SistemaOperativoContext**: mantiene un riferimento alla Strategy, permette di cambiarla a runtime (setStrategy())

## Design Pattern: FACADE
Componenti:

 - **ComputerFacade**: coordina Bios, HardDisk, SistemaOperativoContext
