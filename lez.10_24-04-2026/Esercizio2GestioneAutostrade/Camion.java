public class Camion extends Veicolo {

    private double pesoCarico;

    public Camion(String targa, double velocita, int numeroAssi, double pesoCarico) {
        super(targa, velocita, numeroAssi);
        this.pesoCarico = pesoCarico;
    }

    // Getter e setter della variabile d'instanza pesoCarico:
    public double getPesoCarico() {
        return pesoCarico;
    }

    public void setPesoCarico(double pesoCarico) {
        this.pesoCarico = pesoCarico;
    }

    // Override del metodo astratto calcolaPedaggio() della superclasse astratta Veicolo:
    @Override
    public double calcolaPedaggio() {
        return 5 + (getNumeroAssi() * 2) + (pesoCarico * 0.1);
    }

    // Override del metodo getInfo() che mostra i dati generici del veicolo più quelli specifici per il camion:
    @Override
    public String getInfo() {
        return super.getInfo() +
                ", Peso carico: " + pesoCarico +
                ", Tipo: Camion";
    }
}
