public class Moto extends Veicolo {

    private int cilindrata;

    public Moto(String targa, double velocita, int numeroAssi, int cilindrata) {
        super(targa, velocita, numeroAssi);
        this.cilindrata = cilindrata;
    }

    // Getter e setter della variabile d'instanza cilindrata:
    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    // Override del metodo astratto calcolaPedaggio() della superclasse astratta Veicolo:
    @Override
    public double calcolaPedaggio() {
        return 1.5 + (cilindrata / 1000.0);
    }

    // Override del metodo getInfo() che mostra i dati generici del veicolo più quelli specifici per la moto:
    @Override
    public String getInfo() {
        return super.getInfo() +
                ", Cilindrata: " + cilindrata +
                ", Tipo: Moto";
    }
}
