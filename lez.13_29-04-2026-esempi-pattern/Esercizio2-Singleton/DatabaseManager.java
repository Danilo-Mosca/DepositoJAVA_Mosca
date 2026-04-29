public class DatabaseManager {
    
    // Istanza unica (Singleton):
    private static DatabaseManager istanzaDatabaseManager;
    // Contatore delle connessioni al database:
    private int contatore = 0;

    // Costruttore privato per impedire l'istanziazione diretta
    private DatabaseManager() {
    }

    // getter del contatore che permette di visualizzare il numero totale di connessioni al database
    public int getConnectionCount(){
        return this.contatore;
    }

    // Metodo pubblico statico per ottenere (o creare nel caso non esistesse) l'unica istanza della classe DatabaseManager:
    public static DatabaseManager getIstanza() {
        // Se l'istanza non esiste, viene creata:
        if (istanzaDatabaseManager == null) {
            // Se non esiste creo l'istanza di DatabaseManager:
            istanzaDatabaseManager = new DatabaseManager();
        }
        // Restituisce l'istanza esistente o appena creata
        return istanzaDatabaseManager;
    }

    // Metodo usato per scrivere i messaggi
    public void connect() {
        contatore++;            // Incremento il contatore ad ogni chiamata del metodo connect()
        System.out.println("Connessione stabilita. Connessioni attive: " + contatore);
    }
}
