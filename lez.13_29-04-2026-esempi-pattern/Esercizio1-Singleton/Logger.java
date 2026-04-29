import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    // Istanza privata statica della classe Logger
    private static Logger istanza;

    // Costruttore privato per impedire l'istanziazione diretta
    private Logger() {
    }

    // Metodo pubblico statico per ottenere (o creare nel caso non esistesse) l'unica istanza della classe Logger:
    public static Logger getIstanza() {
        // Se l'istanza non esiste, viene creata:
        if (istanza == null) {
            // Se non esiste creo l'istanza di Logger:
            istanza = new Logger();
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