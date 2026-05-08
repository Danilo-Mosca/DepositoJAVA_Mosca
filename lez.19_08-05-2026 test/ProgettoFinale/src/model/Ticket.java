package model;

// MODEL: rappresenta l'entità Ticket
public class Ticket {
    private int id;
    private String title;
    private String description;
    private boolean resolved;

    // Costruttore  per creare un nuovo ticket con un ID, titolo, descrizione e se è stato risolto o meno
    public Ticket(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.resolved = false;
    }

    // Getter e setter per accedere e modificare le proprietà del ticket
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    // Override del metodo toString() ereditato dalla classe Object
    // Ritorna i ticket da stampare in console
    @Override
    public String toString() {
        return id + " - " + title + " | ticket risolto: " + resolved;
    }
}
