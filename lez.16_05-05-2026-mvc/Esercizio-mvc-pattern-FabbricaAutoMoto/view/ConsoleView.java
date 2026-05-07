package view;
// Classe VIEW (si occupa di mostrare i dati) e Observer, osservatore concreto
// In questo caso la View si occupa semplicemente di stampare in console
import java.util.List;

import model.Observer;
import model.Veicolo;

public class ConsoleView implements Observer {
    
    public void mostraVeicoli(List<Veicolo> listaVeicoli){
        for (Veicolo veicolo : listaVeicoli) {
            System.out.println(veicolo.getDescrizione());
        }
    }
    
    @Override
    public void update(String messaggio) {
        System.out.println("NOTIFICA DI AGGIORNAMENTO! " + messaggio);
    }
}