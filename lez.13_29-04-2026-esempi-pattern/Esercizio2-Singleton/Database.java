import java.util.ArrayList;

public class Database {
    // Istanza unica (Singleton) del Database:
    private static Database istanzaDatabase;
    private ArrayList<Utente> listaUtenti; // ArrayList che conterrà tutti i dati salvati nel database

    // Costruttore privato per impedire l'istanziazione diretta:
    private Database() {
        this.listaUtenti = new ArrayList<>(); // ArrayList contenente tutti i dati salvati nel database
    }

    // Metodo pubblico statico per ottenere (o creare nel caso non esistesse)
    // l'unica istanza della classe Database:
    public static Database getIstanza() {
        // Se l'istanza non esiste, viene creata:
        if (istanzaDatabase == null) {
            // Se non esiste creo l'istanza di Database:
            istanzaDatabase = new Database();
        }
        // Restituisce l'istanza esistente o appena creata
        return istanzaDatabase;
    }

    /* GETTER E SETTER: */

    // Metodo che ritorna tutti gli utenti:
    public ArrayList<Utente> getAllUtenti() {
        return this.listaUtenti;
    }

    // Metodo che ritorna il singolo utente:
    public Utente getSingleUtente(String nome) {
        for (Utente utente : listaUtenti) {
            // Controllo se l'utente è presente:
            if (utente.getNome().equalsIgnoreCase(nome)) {
                return utente;
            }
        }
        // Se l'utente non viene trovato restituisco null:
        return null;
    }

    // Metodo che modifica il singolo utente:
    public void changeSingleUtente(Utente changeUtente, String nome) {
        boolean isAggiornato = false; // Variabile booleana di controlla modifica utente
        for (Utente utente : listaUtenti) {
            if (nome.equalsIgnoreCase(utente.getNome())) {
                utente.setNome(changeUtente.getNome());
                utente.setCognome(changeUtente.getCognome());
                utente.setEta(changeUtente.getEta());
                isAggiornato = true;
                System.out.println("Utente aggiornato!");
            }
        }
        if (!isAggiornato) {
            System.out.println("L'utente inserito non esiste nel database!");
        }
    }

    // Metodo che aggiunge un utente alla lista:
    public void addUtente(Utente utente) {
        this.listaUtenti.add(utente);
    }

    // Metodo che rimuove un utente dalla lista:
    public void removeSingleUtente(String name) {
        boolean isDeleted = false; // Variabile booleana di controlla modifica utente
        Utente utenteDaRimuovere = null; // Creo un'istanza di Utente e lo inizializzo a null
        for (Utente utente : listaUtenti) {
            if (utente.getNome().equalsIgnoreCase(name)) {
                isDeleted = true;
                utenteDaRimuovere = utente; // Non creo un nuovo oggetto ma gli assegno lo stesso indirizzo di quello di
                                            // utente, quindi entrambi puntano allo stesso oggetto
                break;
            }
        }
        if (!isDeleted) {
            System.out.println("Non è stato possibile eliminare l'utente perché questo non esiste nel database!");
        } else {
            listaUtenti.remove(utenteDaRimuovere);
            System.out.println("Utente: " + name + " rimosso correttamente!");
        }
    }

    // Metodo che rimuove tutti i dati dal database:
    public void removeAll() {
        listaUtenti.removeAll(listaUtenti);
    }
}
