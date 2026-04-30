/* DESIGN PATTERN: SINGLETON  e SUBJECT */
// Definizione della classe Singleton nonchè Subject (osservata) nel pattern Observer

import java.util.ArrayList;
import java.util.List;

public class S_GestoreNotifiche implements Subject {
    // Istanza privata statica della classe Singleton
    private static S_GestoreNotifiche instance;
    // Lista degli Observer:
    private List<Observer> utenti;

    // Costruttore privato per impedire l'istanziazione diretta
    private S_GestoreNotifiche() {
        utenti = new ArrayList<>();
    }

    // Metodo pubblico statico per ottenere l'unica istanza della classe
    public static S_GestoreNotifiche getInstance() {
        // Se l'istanza non esiste, viene creata
        if (instance == null) {
            instance = new S_GestoreNotifiche(); // eseguo il costruttore privato se l'istanza non esiste
        }
        // Restituisce l'istanza esistente o appena creata
        return instance;
    }

    // Metodi di registrazione e cancellazione di ricezione notifiche degli utenti:
    @Override
    public void registraUtente(Observer osservatore) {
        this.utenti.add(osservatore);
    }

    @Override
    public void rimuoviUtente(String nomeRegistrato, String cognomeRegistrato) {
        boolean trovato = false;
        for (Observer utente : utenti) {
            if (utente.getNome().equalsIgnoreCase(nomeRegistrato)
                    && utente.getCognome().equalsIgnoreCase(cognomeRegistrato)) {
                this.utenti.remove(utente);
                trovato = true;
                break;
            }
        }
        if (!trovato) {
            System.out.println("Non è stato possibile rimuovere l'utente. Utente non trovato");
        }
    }

    // Metodo che invia la notifica da mandare a tutti gli utenti registrati:
    @Override
    public void notificaUtenti(String messaggio) {
        for (Observer utenteOsservatore : utenti) {
            utenteOsservatore.aggiornamento(messaggio);
        }
    }

    // Metodo di pubblicazione notifica:
    public void pubblicaAvviso(String messaggio) {
        System.out.println("NUOVA NOTIFICA: " + messaggio);
        notificaUtenti(messaggio);
    }
}
