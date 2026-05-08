package controller;

import model.Ticket;

// PATTERN: FACADE
public class TicketFacade {

    private TicketRepository repo = TicketRepository.getInstance();
    private TicketService service;

    public TicketFacade(TicketService service) {
        this.service = service;
    }

    // Metodo che crea il ticket
    public void create(String title, String desc) {
        Ticket t = repo.add(title, desc);
        service.notifyAllObservers("Creato ticket: " + t.getTitle());
    }

    // Metodo che mostra i ticket
    public void list() {
        // Se la lista è vuota
        if (repo.findAll() == null) {
            System.out.println("Nessun ticket da mostrare");
        } else {
            for (Ticket t : repo.findAll()) {
                System.out.println(t);
            }
        }
    }

    // Metodo che risolve il ticket
    public void resolve(int id) {
        Ticket t = repo.findById(id);
        if (t != null) {
            t.setResolved(true);
            service.notifyAllObservers("Ticket risolto: " + t.getTitle());
        } else {
            System.out.println("Ticket non trovato");
        }
    }

    // Metodo che elimina il ticket
    public void delete(int id) {
        boolean deleted = repo.delete(id);
        if (deleted) {
            service.notifyAllObservers("Ticket eliminato ID: " + id);
        } else {
            System.out.println("Ticket non trovato");
        }
    }
}