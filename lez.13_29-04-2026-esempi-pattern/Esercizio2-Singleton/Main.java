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

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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

        // Creo l'instanza Singleton di Database:
        Database database = Database.getIstanza();

        // Creo lo Scanner per l'input dell'utente:
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true; // Variabile booleana che controlla l'esecuzione del ciclo
        do {
            System.out.println("===== MENU DATABASE =====");
            System.out.println("1. Salva un dato nel database");
            System.out.println("2. Visualizza tutti i dati salvati nel database");
            System.out.println("3. Esci");
            System.out.print("Scegli: ");

            String sceltaUtente = scanner.nextLine();
            switch (sceltaUtente) {
                case "1":
                    System.out.print("Inserisci dato da salvare: ");
                    String dato = scanner.nextLine();
                    database.setDatabase(dato);
                    break;

                case "2":
                    if (database.getDatabase().size() > 0) {
                        System.out.println("Dati presenti nel Database:");
                        for (String datiSingoli : database.getDatabase()) {
                            System.out.println("- " + datiSingoli);
                        }
                    } else {
                        System.out.println("Il database non ha memorizzato nessun dato!");
                    }
                    break;

                case "3":
                    isRunning = false;
                    break;

                default:
                    System.out.println("Scelta non valida! Inserisci un valore compreso tra 1 e 3");
                    break;
            }

        } while (isRunning);

        scanner.close();
    }
}
