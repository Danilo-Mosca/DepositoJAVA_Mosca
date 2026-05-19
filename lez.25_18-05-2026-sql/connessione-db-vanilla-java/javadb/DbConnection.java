import java.util.Properties;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;

//Classe Singleton della connessione al database, con la quale evito connessioni multiple ed inutili, migliorandone le performance. Questa classe diventa una sola porta sempre aperta verso il database
public class DbConnection {

    private static Connection conn = null;

    public static Connection getConnection() {

        //Se conn è diverso da null significa che la connessione è già stata aperta, e quindi dico di riutilizzarla non di crearne un'altra
        if (conn != null) {
            return conn;
        }

        //Tipo di classe che richiama il file config.properties contenente tutti i dati sensibili per la connessione al database
        Properties dbProperties = new Properties();

        //Dico a java di aprire il file config.properties (contenuto nella working directory del progetto) e usarlo come input, e di chiuderlo automaticamente quando ho finito di importare i valori in esso contenuti
        try (FileInputStream input = new FileInputStream("config.properties")) {
            // Legge il file config.properties tramite lo stream input e carica tutto dentro l’oggetto dbProperties di tipo Properties.
            dbProperties.load(input);
            //Assegno i valori di dbProperties a singole variabili utilizzando il metodo getProperty() (dell'oggetto Properties) per recuperare il valore associato a quella chiave (esempio "DB_DRIVER"). Questo mi permette di trasformare il file .properties in variabili Java utilizzabili nel codice
            String DB_DRIVER = dbProperties.getProperty("DB_DRIVER");
            String DB_URL = dbProperties.getProperty("DB_URL");
            String DB_USERNAME = dbProperties.getProperty("DB_USERNAME");
            String DB_PASSWORD = dbProperties.getProperty("DB_PASSWORD");

            //Carica dinamicamente il driver JDBC in memoria (in questo caso com.mysql.cj.jdbc.Driver). Senza questo: Java NON sa come parlare con MySQL, manca il “ponte” JDBC → database
            Class.forName(DB_DRIVER);   //Anche se in realtà con JDBC 4+ spesso NON serve più, ma si usa ancora per sicurezza.
            
            //Crea la connessione reale al database
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            
            if (conn != null){
                System.out.println("Successfully connected.");
            }else{
                System.out.println("Failed to connect.");
            }
        //Se succede QUALSIASI errore    
        } catch (Exception e) {
            //Stampa l’errore completo
            e.printStackTrace();
        }
        return conn;
    }
}
