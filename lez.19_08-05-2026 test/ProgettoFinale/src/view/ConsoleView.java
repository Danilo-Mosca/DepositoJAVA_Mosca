package view;

import controller.*;
import model.User;

import java.util.Scanner;

// VIEW: gestione input/output + menu
public class ConsoleView {

    private TicketController controller;
    private Scanner scanner = new Scanner(System.in);

    private User currentUser;

    public ConsoleView(TicketController controller) {
        this.controller = controller;
    }

    // Avvio dell'applicazione
    public void start() {

        login(); // Richiamo il metodo per mostrare il login

        int choice = -1;

        while (choice != 0) {

            System.out.println("\n===== MENU TICKET =====");

            if (!currentUser.isAdmin()) {
                System.out.println("1. Crea un ticket");
                System.out.println("2. Visualizza i ticket");
            } else {
                System.out.println("1. Crea un ticket");
                System.out.println("2. Visualizza i ticket");
                System.out.println("3. Risolvi un ticket");
                System.out.println("4. Elimina un ticket");
            }

            System.out.println("0. Esci");

            System.out.print("Scelta: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    create();
                    break;

                case 2:
                    controller.list();
                    break;

                case 3:
                    if (currentUser.isAdmin())
                        resolve();
                    break;

                case 4:
                    if (currentUser.isAdmin())
                        delete();
                    break;

                case 0:
                    System.out.println("Uscita dal programma");
                    break;
            }
        }
    }

    // Metodo che mostra il login e permette all'utente di inserire username,
    // password e ruolo (USER o ADMIN) per accedere al sistema
    private void login() {

        System.out.println("===== LOGIN =====");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Controllo l'inserimento del ruolo per assicurarsi che sia valido (USER o
        // ADMIN), e se non lo è, chiedo di inserirlo nuovamente finché non viene
        // inserito un ruolo valido.
        String role ="";
        boolean isInvalidRole = true;
        while (isInvalidRole) {
            System.out.print("Ruolo (USER / ADMIN): ");
            role = scanner.nextLine().toUpperCase();
            if (role.equalsIgnoreCase("USER") || role.equalsIgnoreCase("ADMIN")) {
                isInvalidRole = false;
            } else {
                System.out.println("Ruolo non valido. Inserisci USER o ADMIN!");
            }
        }

        currentUser = new User(username, password, role);

        System.out.println("Login effettuato come: " + role);
    }

    // Metodo che permette la creazione di un nuovo ticket chiedendo all'utente di
    // inserire il titolo e la descrizione del ticket, e poi chiama il controller
    // per creare il ticket
    private void create() {
        System.out.print("Titolo: ");
        String title = scanner.nextLine();

        System.out.print("Descrizione: ");
        String desc = scanner.nextLine();

        controller.create(currentUser, title, desc);
    }

    // Metodo che permette la risoluzione di un ticket chiedendo all'utente di
    // inserire l'ID del ticket, e poi chiama il controller per risolvere il ticket
    private void resolve() {
        System.out.print("ID ticket: ");
        int id = scanner.nextInt();
        controller.resolve(currentUser, id);
    }

    // Metodo che permette l'eliminazione di un ticket chiedendo all'utente di
    // inserire l'ID del ticket, e poi chiama il controller per eliminare il ticket
    private void delete() {
        System.out.print("ID ticket: ");
        int id = scanner.nextInt();
        controller.delete(currentUser, id);
    }
}