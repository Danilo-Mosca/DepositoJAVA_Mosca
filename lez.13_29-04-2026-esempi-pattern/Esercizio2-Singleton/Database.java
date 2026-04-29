import java.util.ArrayList;

public class Database {
    // Istanza unica (Singleton) del Database:
    private static Database istanzaDatabase;
    private ArrayList<String> database = new ArrayList<>();     //ArrayList contenente tutti i dati salvati nel database

    // Costruttore privato per impedire l'istanziazione diretta:
    private Database(){}

    // getter e setter:
    public ArrayList<String> getDatabase(){
        return this.database;
    }

    public void setDatabase(String dato){
        this.database.add(dato);
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
}
