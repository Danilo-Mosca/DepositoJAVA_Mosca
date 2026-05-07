package View;
import Model.Bevanda;

public class MacchinettaView {
    //visualizza storico ordini
    public void visualizzaStorico(String storicoOrdini) {
        System.out.println("Storico ordini: ");
        System.out.println(storicoOrdini);
    }
    
    //helper stampa bevanda
    private void stampaBevanda(Bevanda bevanda) {
        System.out.println(bevanda.getDescrizione());
        System.out.println(bevanda.getCosto());
    }
    //conferma ordine
    public void confermaOrdine(Bevanda bevanda) {
        System.out.println("Ordine confermato");
        stampaBevanda(bevanda);
    }
    //visualizza messaggio
    public void visualizzaMessaggio(String messaggio) {
        System.out.println(messaggio);
    }
    //bevanda corrente
    public void visualizzaBevandaCorrente(Bevanda bevanda) {
        System.out.println("Bevanda corrente");
        stampaBevanda(bevanda);
    }
    //Stampa menu azioni
    public void visualizzaMenu() {
        System.out.println("Cosa vuoi fare?:");
        System.out.println("1. Crea nuova bevanda");
        System.out.println("2. Aggiungi ingrediente extra");
        System.out.println("3. Visualizza bevanda corrente");
        System.out.println("4. Conferma ordine");
        System.out.println("5. Visualizza storico ordini");
        System.out.println("6. Esci");
    }
    //menu bevande
    public void visualizzaBevande() {
        System.out.println("Bevande:");
        System.out.println("1. Caffe");
        System.out.println("2. Te");
        System.out.println("3. Cioccolata Calda");
    }
    //menu ingredienti extra
    public void visualizzaIngredientiExtra() {
        System.out.println("Ingredienti extra:");
        System.out.println("1. Latte");
        System.out.println("2. Cannella");
        System.out.println("3. Cacao");
        System.out.println("4. Panna");
        System.out.println("5. Zucchero");
    }

}
