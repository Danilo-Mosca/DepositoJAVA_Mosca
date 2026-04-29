/* ESERCIZIO: Design pattern ES Singleton

Realizza una classe DatabaseManager che segua il pattern Singleton. La classe deve:
- 1. Avere un costruttore privato e un metodo statico getInstance() che restituiscesempre la stessa istanza.
- 2. Simulare una connessione al database con un metodo connect() che:
    - Stampi un messaggio del tipo: "Connessione stabilita. Connessioni attive: X"
    - Incrementi un contatore interno ogni volta che viene chiamato.
3.Fornire un metodo getConnectionCount() che restituisca il numero totale diconnessioni effettuate.

Nel main:
    - Dimostra che l’oggetto utilizzato è sempre lo stesso.
    - Stampa il numero totale di connessioni con getConnectionCount().
    - Crea il menu per la gestione del salvataggio e richiamo dei dati

Funzionalità:
    - Salvare un dato del DB
    - Richiamare un dato dal DB
    - Legare la possibilità di creare o richiamare un dato ad un Utente (Se voletesingleton ) 
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /* TEST FUNZIONAMENTO: */
        System.out.println("PROVE FUNZIONAMENTO");
        // Creo l'instanza (se non esiste già) del Singleton DatabaseManager:
        DatabaseManager utenteConnesso1 = DatabaseManager.getIstanza();
        DatabaseManager utenteConnesso2 = DatabaseManager.getIstanza();
        DatabaseManager utenteConnesso3 = DatabaseManager.getIstanza();

        // Dimostro che sto usando sempre lo stesso oggetto di DatabaseManager:
        if (utenteConnesso1 == utenteConnesso2) {
            System.out.println("utenteConnesso1 e utenteConnesso2 sono la stessa istanza!");
        }
        if (utenteConnesso2 == utenteConnesso3) {
            System.out.println("utenteConnesso2 e utenteConnesso3 sono la stessa istanza!");
        }

        // Connetto tutti e 3 al Database:
        utenteConnesso1.connect();
        utenteConnesso2.connect();
        utenteConnesso3.connect();

        // Stampo il numero totale di connessioni attuali:
        System.out.println("Numero di connessioni attuali a database: " + utenteConnesso1.getConnectionCount());
        System.out.println("FINE PROVE FUNZIONAMENTO");
        /* FINE TEST FUNZIONAMENTO */

        // Creo l'instanza Singleton di Database:
        Database database = Database.getIstanza();

        // Creo lo Scanner per l'input dell'utente:
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\n===== MENU DATABASE =====");
            System.out.println("1. Inserisci un nuovo utente nel database");
            System.out.println("2. Modifica un utente nel database");
            System.out.println("3. Elimina un utente nel database");
            System.out.println("4. Visualizza un utente nel database");
            System.out.println("5. Visualizza tutti gli utenti salvati nel database");
            System.out.println("6. Rimuovi tutti gli utenti dal database");
            System.out.println("7. Esci dal programma");
            System.out.print("Scegli: ");

            String sceltaUtente = scanner.nextLine();
            switch (sceltaUtente) {
                case "1":
                    System.out.print("Inserisci il nome del nuovo utente: ");
                    String nomeAdd = scanner.nextLine();
                    System.out.print("\nInserisci il cognome del nuovo utente: ");
                    String cognomeAdd = scanner.nextLine();
                    System.out.print("\nInserisci l'età del nuovo utente: ");
                    int etaAdd = scanner.nextInt();
                    scanner.nextLine(); // pulizia buffer
                    Utente nuovoUtente = new Utente(nomeAdd, cognomeAdd, etaAdd);
                    database.addUtente(nuovoUtente);
                    break;

                case "2":
                    System.out.print("Inserisci il nome dell'utente che vuoi modificare: ");
                    String searchNome = scanner.nextLine();
                    System.out.print("Inserisci il nuovo nome dell'utente: ");
                    String nomeChange = scanner.nextLine();
                    System.out.print("\nInserisci il nuovo cognome dell'utente: ");
                    String cognomeChange = scanner.nextLine();
                    System.out.print("\nInserisci la nuova età dell'utente: ");
                    int etaChange = scanner.nextInt();
                    scanner.nextLine(); // pulizia buffer
                    Utente changeUtente = new Utente(nomeChange, cognomeChange, etaChange);
                    database.changeSingleUtente(changeUtente, searchNome);
                    break;

                case "3":
                    System.out.print("Inserisci il nome dell'utente che vuoi eliminare: ");
                    String nomeDelete = scanner.nextLine();
                    database.removeSingleUtente(nomeDelete);
                    break;

                case "4":
                    System.out.print("Inserisci il nome dell'utente che vuoi visualizzare: ");
                    String nomeVisualizzato = scanner.nextLine();
                    Utente utenteVisualizzato = database.getSingleUtente(nomeVisualizzato);
                    if (utenteVisualizzato == null) {
                        System.out.println("Nel database non esiste un utente di nome: " + nomeVisualizzato);
                    } else {
                        System.out.println("Nome: " + utenteVisualizzato.getNome() + " - Cognome: "
                                + utenteVisualizzato.getCognome() + " - Età: " + utenteVisualizzato.getEta());
                    }
                    break;

                case "5":
                    if (database.getAllUtenti().isEmpty()) {
                        System.out.println("Il database non ha memorizzato nessun utente!");
                    } else {
                        ArrayList<Utente> allUtenti = database.getAllUtenti();
                        System.out.println("===== LISTA UTENTI PRESENTI NEL DATABASE =====");
                        for (Utente utente : allUtenti) {
                            System.out.println("Nome: " + utente.getNome() + " - Cognome: " + utente.getCognome()
                                    + " - Età: " + utente.getEta());
                        }
                    }
                    break;

                case "6":
                    if (database.getAllUtenti().isEmpty()) {
                        System.out.println("Il database non ha memorizzato nessun utente!");
                    } else {
                        database.removeAll(); // Rimuovo tutti i dati presenti nel database
                        System.out.println("Tutti i dati presenti nel database sono stati rimossi!");
                    }
                    break;

                case "7":
                    scanner.close(); // Chiudo lo scanner
                    return; // Ed esco dal ciclo

                default:
                    System.out.println("Scelta non valida! Inserisci un valore compreso tra 1 e 3");
                    break;
            }
        } while (true);
    }
}
