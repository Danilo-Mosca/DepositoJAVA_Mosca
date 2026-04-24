public class Auto extends Veicolo {

    private int numeroPasseggeri;

    public Auto(String targa, double velocita, int numeroAssi, int numeroPasseggeri) {
        super(targa, velocita, numeroAssi);
        this.numeroPasseggeri = numeroPasseggeri;
    }

    // Getter e setter della variabile d'instanza numeroPasseggeri:
    public int getNumeroPasseggeri() {
        return numeroPasseggeri;
    }

    public void setNumeroPasseggeri(int numeroPasseggeri) {
        this.numeroPasseggeri = numeroPasseggeri;
    }

    // Override del metodo astratto calcolaPedaggio() della superclasse astratta Veicolo:
    @Override
    public double calcolaPedaggio() {
        return 2.5 + (getNumeroAssi() * 0.5);
    }

    // Override del metodo getInfo() che mostra i dati generici del veicolo più quelli specifici per l'auto:
    @Override
    public String getInfo() {
        return super.getInfo() +
                ", Passeggeri: " + numeroPasseggeri +
                ", Tipo: Auto";
    }
}
