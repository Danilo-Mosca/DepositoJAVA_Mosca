
// GestioneNotifiche è sia il "Singleton" che il "Subject" degli Observer
import java.util.ArrayList;
import java.util.List;

public class S_NotificationManager implements Subject{
    // Variabile statica che contiene l'unica istanza della classe S_NotificationManager:
    private static S_NotificationManager uniqueInstance;
    // Lista degli Observer (osservatori):
    private List<Observer> observers = new ArrayList<>();

    // Costruttore privato per prevenire l'istanziazione diretta:
    private S_NotificationManager() {
    }

    // Fornisce un punto di accesso globale per l'ottennimento dell'istanza (metodo pubblico statico che crea o ottinel l'unica istanza della classe):
    public static S_NotificationManager getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new S_NotificationManager();           // eseguo il costruttore privato se l'istanza non esiste
        }
        return uniqueInstance;          // Restituisce l'istanza esistente o appena creata
    }

    // Metodi di registrazione e cancellazione di ricezione notifiche degli utenti:

    // Aggiunta nuovo Observer (Utente)
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Rimozione Observer (Utente)
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Metodo che invia la notifica da mandare a tutti gli Observer (utenti registrati):
    public void inviaNotifica(String messaggio) {
        for (Observer observer : observers) {
            observer.update(messaggio);
        }
    }
}
