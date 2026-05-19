import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbMain {
    public static void main(String[] args) {
        
        //Chiama il metodo getConnection() della classe DbConnection ricevendo un oggetto Connection già pronto e lo salva nella variabile connessione. Gli dico Dammi la connessione al database (già configurata)
        Connection connessione = DbConnection.getConnection();

        //Codice al cui interno possono generarsi degli errori e li devo intercettare con il try/catch
        try {
            // Creo la query sql
            String QUERY = "SELECT * FROM city ORDER BY city.name DESC LIMIT 10;"; // query

            //Creo un oggetto di tipo Statement che serve a scrivere la query SQL sul database
            Statement stmt = connessione.createStatement();
            //Esegue la query sql, riceve il risultato dal database e lo salva in un oggetto di tipo ResultSet che altro non è che una tabella virtuale in memoria
            ResultSet rs = stmt.executeQuery(QUERY);

            //Scorro tutte le righe del risultato e le stampo in console
            while (rs.next()) {
                // rs.getString("Name") prende il valore della colonna Name è lo stampa
                System.out.print(rs.getString("Name") + " - ");
                System.out.println(rs.getString("CountryCode"));
            }

        //Se qualcosa va male (query sbagliata, connessione persa, tabella inesistente)
        } catch (Exception e) {
            //Stampo l'errore completo
            e.printStackTrace();
        }
    }
}
