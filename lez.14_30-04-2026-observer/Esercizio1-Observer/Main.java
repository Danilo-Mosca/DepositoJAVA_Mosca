/* ESERCIZIO: Design pattern ES Observer
Esercizio Facile – Sistema di Notifica Meteo
Obiettivo: Simulare un sistema dove una stazione meteo (subject) notifica più display (observer) quando cambia la temperatura.

Requisiti:
    - Creare un'interfaccia Display con il metodo aggiorna(float temperatura).
    - Implementare la classe StazioneMeteo con:
        - una lista di display registrati;
        - metodi aggiungiDisplay, rimuoviDisplay, notificaDisplay;
        - un metodo setTemperatura(float t) che aggiorna la temperatura e notifica.
    - Implementare almeno due display (es. DisplayConsole, DisplayMobile) che stampano ilvalore ricevuto. 
*/

public class Main {
    public static void main(String[] args) {

        // Creazione sistema, il Subject, l'osservato:
        StazioneMeteo stazione = new StazioneMeteo();

        // Creo gli Observer:
        Display console = new DisplayConsole();
        Display mobile = new DisplayMobile();

        // Registrazione degli Observer: voglio che console e e mobile siano notificati
        stazione.aggiungiDisplay(console);
        stazione.aggiungiDisplay(mobile);

        // Cambio stato:
        stazione.setTemperatura(25.5f);
        stazione.setTemperatura(30.0f);
    }
}