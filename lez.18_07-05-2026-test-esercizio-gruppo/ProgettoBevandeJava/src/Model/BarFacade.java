package Model;

public class BarFacade {

    // Riferimento al Singleton per la gestione 
    private S_GestoriOrdini gestore = S_GestoriOrdini.getIstanza();
    //strategy
    private DecoratorBevanda strategy;

    //setter strategy
    public void setStrategy(DecoratorBevanda strategy) {
        this.strategy = strategy;
    }
    // --- 1. Creazione bevanda (Semplificate) ---
    public Bevanda creaCaffe() {
        return new Caffe();
    }

    public Bevanda creaTe() {
        return new Te();
    }

    public Bevanda creaCioccolata() {
        return new CioccolataCalda();
    }
    // --- 2. Decorazione con Pattern Strategy ---
    public Bevanda aggiungiIngrediente(Bevanda bevanda) {
        if (bevanda == null) {
            return null;
        }
        if(strategy == null) {
            return bevanda;
        }
        return strategy.applica(bevanda);
    }

    // --- 3. Interfaccia verso il singleton ---
    public void archiviaOrdine(Bevanda bevandaFinale) {
        if (bevandaFinale != null) {
            gestore.confermaOrdine(bevandaFinale);
        }
    }
    // stampa storico
    public String stampaStorico() {
        return gestore.visualizzaStorico();
    }
}
