// Fabbrica (Singleton + Subject per Observer)

import java.util.List;
import java.util.ArrayList;

public class S_Fabbrica implements Subject {
    // Istanza unica di S_Fabbrica
    private static S_Fabbrica istanza;

    private List<Observer> listaObserver = new ArrayList<>();
    private List<Veicolo> listaVeicoli = new ArrayList<>();

    // Costruttore privato e vuoto per impedire l'istanziazione diretta
    private S_Fabbrica() {
    }

    // Metodo pubblico e statico (quindi accessibile senza istanziare la classe)
    // che permette di accedere od ottenere l'istanza della classe Fabbrica
    public static S_Fabbrica getIstanza() {
        // Se l'istanza non esiste, viene creata:
        if (istanza == null) {
            // Se non esiste creo l'istanza di S_Fabbrica:
            istanza = new S_Fabbrica();
        }
        // Restituisce l'istanza esistente o appena creata
        return istanza;
    }

    /* Implemento i metodi dell'interfaccia Subject: sono i metodi del Subject (osservato)
    Metodi dell'observer che registrano e notificano i nuovi Observer */
    
    // Registro un nuovo observer
    @Override
    public void addObserver(Observer observer) {
        listaObserver.add(observer);
    }

    // Metodo che invia le notifiche a tutti gli observer registrati
    @Override
    public void notifyObservers(String messaggio) {
        for (Observer observer : listaObserver) {
            observer.update(messaggio);
        }
    }

    /* Metodi che aggiungono i veicoli prodotti all'arraylist listaVeicoli e che ritornano la lista dei veicoli prodotti */
    // Aggiungo il veicolo prodotto all'arraylist listaVeicoli
    public void produciVeicolo(Veicolo veicolo) {
        listaVeicoli.add(veicolo);
        // Dopo aver aggiunto il veicolo all'arraylist richiamo il metodo
        // notifyObservers() che mostra le notifiche a tutti gli utenti
        notifyObservers("Nuovo veicolo prodotto: " + veicolo.getDescrizione());
    }

    // Ritorno la lista di tutti i veicoli prodotti
    public List<Veicolo> getVeicoli() {
        return listaVeicoli;
    }
}