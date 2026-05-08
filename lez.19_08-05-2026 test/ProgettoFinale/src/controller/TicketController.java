package controller;

import model.User;

// CONTROLLER: gestisce logica e permessi
public class TicketController {

    private TicketFacade facade;

    public TicketController(TicketFacade facade) {
        this.facade = facade;
    }

    // crea ticket: sia User che Admin
    public void create(User user, String title, String desc) {
        facade.create(title, desc);
    }

    // Metodo che mostra la lista dei ticket (sia per User che per Admin)
    public void list() {
        facade.list();
    }

    // Metodo che risolve un ticket: solo Admin
    public void resolve(User user, int id) {
        if (user.isAdmin()) {
            facade.resolve(id);
        } else {
            System.out.println("Accesso negato");
        }
    }

    // Metodo che elimina un ticket: solo Admin
    public void delete(User user, int id) {
        if (user.isAdmin()) {
            facade.delete(id);
        } else {
            System.out.println("Accesso negato");
        }
    }
}