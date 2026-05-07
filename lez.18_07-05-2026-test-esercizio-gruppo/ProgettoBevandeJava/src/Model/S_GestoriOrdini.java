package Model;

import java.util.ArrayList;
import java.util.List;
// Singleton gestore ordini
/**
 * Singleton responsabile della gestione degli ordini.
 * Garantisce che esista UNA SOLA istanza della classe
 * durante tutta l'esecuzione del programma.
 */
public class S_GestoriOrdini {
    // Istanza unica della classe (Singleton)
    private static S_GestoriOrdini istanza;
    // Lista che contiene lo storico degli ordini effettuati
    private List<String> storicoOrdini;

    // Costruttore privato
    private S_GestoriOrdini() {
        storicoOrdini = new ArrayList<>();
    }
    // Metodo per ottenere l'unica istanza di accesso globale. Se non esiste, viene creata
    public static S_GestoriOrdini getIstanza() {

        if (istanza == null) {
            istanza = new S_GestoriOrdini();
        }

        return istanza;
    }

    // Metodi di gestione ordini:

    /**
     * Conferma un ordine e lo salva nello storico
     *
     * bevanda bevanda ordinata
     * messaggio di conferma ordine
     */
    public String confermaOrdine(Bevanda bevanda) {

        String ordine = bevanda.getDescrizione()  + " - euro " + String.format("%.2f", bevanda.getCosto());

        storicoOrdini.add(ordine);

        return "Ordine confermato!";
    }
    // Visualizza storico ordini
    /**
     * Restituisce la lista degli ordini in formato stringa
     * storico ordini oppure messaggio vuoto
     */
    public String visualizzaStorico() {
        String listaOrdini = "";
        // Controllo se sono presenti ordini
        if (storicoOrdini.isEmpty()) {
            return "Nessun ordine presente.";
        }

        for (int i = 0; i < storicoOrdini.size(); i++) {
            listaOrdini += (i + 1) + ". " + storicoOrdini.get(i) + "\n";
        }
        return listaOrdini;
    }
}
