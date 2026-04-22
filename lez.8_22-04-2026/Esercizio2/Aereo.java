public class Aereo {
    private String modello;
    private int numeroPosti;
    private String codice;

    // Costruttore
    public Aereo(String modello, int numeroPosti, String codice) {
        this.modello = modello;
        setNumeroPosti(numeroPosti); // uso il setter per validazione
        this.codice = codice;
    }

    // Getter
    public String getModello() {
        return modello;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public String getCodice() {
        return codice;
    }

    // Setter
    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setNumeroPosti(int numeroPosti) {
        if (numeroPosti > 0) {
            this.numeroPosti = numeroPosti;
        } else {
            System.out.println("Numero posti non valido!");
        }
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    //Override metodo toString()
    @Override
    public String toString() {
        return "Aereo: " +
                "modello='" + modello + '\'' +
                ", codice='" + codice + '\'' +
                ", numeroPosti=" + numeroPosti;
    }
}
