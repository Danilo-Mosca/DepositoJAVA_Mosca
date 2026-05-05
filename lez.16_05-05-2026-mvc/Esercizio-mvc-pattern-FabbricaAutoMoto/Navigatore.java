// Decoratore concreto "Navigatore" che estende la classe astratta decorator "VeicoloDecorator"
public class Navigatore extends VeicoloDecorator {
    // Costruttore
    public Navigatore(Veicolo veicolo){
        super(veicolo);
    }

    @Override
    public String getDescrizione(){
        return veicolo.getDescrizione() + " con navigatore";
    }
}