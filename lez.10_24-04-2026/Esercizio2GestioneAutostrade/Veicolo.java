public abstract class Veicolo {
    private String targa;
    private double velocita;
    private int numeroAssi;

    public Veicolo(String targa, double velocita, int numeroAssi) {
        this.targa = targa;
        setVelocita(velocita);
        setNumeroAssi(numeroAssi);
    }

    // Getter e setter:
    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public double getVelocita() {
        return velocita;
    }

    public void setVelocita(double velocita) {
        if (velocita < 0) {
            this.velocita = 0;
        } else {
            this.velocita = velocita;
        }
    }

    public int getNumeroAssi() {
        return numeroAssi;
    }

    public void setNumeroAssi(int numeroAssi) {
        if (numeroAssi < 0) {
            this.numeroAssi = 0;
        } else {
            this.numeroAssi = numeroAssi;
        }
    }

    // Metodo astratto calcolaPedaggio():
    public abstract double calcolaPedaggio();

    // Metodo getInfo() che mostra i dati generici del veicolo:
    public String getInfo() {
        return "Targa: " + targa +
                ", Velocità: " + velocita +
                ", Assi: " + numeroAssi;
    }
}
