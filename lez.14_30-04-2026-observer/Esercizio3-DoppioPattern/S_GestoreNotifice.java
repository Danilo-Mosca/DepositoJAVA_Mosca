/* DESIGN PATTERN: SINGLETON */
// Definizione della classe Singleton

import java.util.ArrayList;
import java.util.List;

public class S_GestoreNotifice {
    // Istanza privata statica della classe Singleton
    private static S_GestoreNotifice instance;
    // Lista degli Observer:
    private List<Observer> utenti;

    // Costruttore privato per impedire l'istanziazione diretta
    private S_GestoreNotifice() {
        utenti = new ArrayList<>();
    }

    // Metodo pubblico statico per ottenere l'unica istanza della classe
    public static S_GestoreNotifice getInstance() {
        // Se l'istanza non esiste, viene creata
        if (instance == null) {
            instance = new S_GestoreNotifice();     //eseguo il costruttore privato se l'istanza non esiste
        }
        // Restituisce l'istanza esistente o appena creata
        return instance;
    }

    // Metodi di registrazione e cancellazione di ricezione notifiche degli utenti:
    public void registraUtente(Observer osservatore){
        this.utenti.add(osservatore);
    }

    public void rimuoviUtente(Observer osservatore) {
        this.utenti.remove(osservatore);
    }

    // Metodo di pubblicazione notifica:
    public void pubblicaAvviso(String messaggio) {
        System.out.println("NUOVA NOTIFICA: " + messaggio);
        for (Observer utenteOsservatore : utenti) {
            utenteOsservatore.aggiornamento(messaggio);
        }
    }
}
