package controller;

import model.Ticket;
import java.util.*;

// Classe Singleton
// Unico punto di accesso
public class TicketRepository {

    private static TicketRepository instance;           // Istanza unica
    private List<Ticket> tickets = new ArrayList<>();   // Lista dei ticket
    private int counter = 1;                            // Contatore id dei ticket

    // Costruttore privato della Singleton
    private TicketRepository() {
    }

    // Accesso globale all'instanza (o prima creazione nel caso in cui non esista)
    public static TicketRepository getInstance() {
        if (instance == null) {
            instance = new TicketRepository();
        }
        return instance;
    }

    // Creazione di un nuovo ticket, aggiunta alla lista e ritorno del ticket creato
    public Ticket add(String title, String desc) {
        Ticket t = new Ticket(counter, title, desc);
        counter++;
        tickets.add(t);
        return t;
    }

    // Ritorna la lista dei ticket
    public List<Ticket> findAll() {
        if (tickets.isEmpty()) {
            return null;
        }
        return tickets;
    }

    // Ritorna il ticket con l'id specificato, o null se non esiste
    public Ticket findById(int id) {
        for (Ticket t : tickets) {
            if (t.getId() == id)
                return t;
        }
        return null;
    }

    // Elimina il ticket con l'id specificato dalla lista
    public boolean delete(int id) {
        boolean found = false;
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId() == id) {
                tickets.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            return false;
        }
        return found;
    }
}