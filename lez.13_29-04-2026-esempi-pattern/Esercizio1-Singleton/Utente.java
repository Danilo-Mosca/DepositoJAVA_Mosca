import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utente {
    // Istanza privata statica della classe Logger
    private static Utente istanza;

    // Costruttore privato per impedire l'istanziazione diretta
    private Utente(){}

    // Metodo pubblico statico per ottenere (o creare nel caso non esistesse) l'unica istanza della classe Utente:
    public static Utente getIstanza(){
        // Se l'istanza non esiste, viene create:
        if(istanza == null){
            // Se non esiste creo l'istanza di Utente:
            istanza = new Utente();
        }
        // Restituisce l'istanza esistente o appena creata
        return istanza;
    }

    // Metodo usato per scrivere i messaggi
    public void scriviMessaggio(String messaggio) {
        DateTimeFormatter formattatoreData = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dataOra = LocalDateTime.now().format(formattatoreData);
        System.out.println("[" + dataOra + "] " + messaggio);
    }
}
