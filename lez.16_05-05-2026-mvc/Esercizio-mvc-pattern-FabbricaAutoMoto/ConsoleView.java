// Classe VIEW (si occupa di mostrare i dati) e Observer, osservatore concreto
import java.util.List;

public class ConsoleView implements Observer {
    
    public void mostraVeicoli(List<Veicolo> listaVeicoli){
        for (Veicolo veicolo : listaVeicoli) {
            System.out.println(veicolo.getDescrizione());
        }
    }
    
    @Override
    public void update(String messaggio) {
        System.out.println("AGGIORNAMENTO " + messaggio);
    }
}