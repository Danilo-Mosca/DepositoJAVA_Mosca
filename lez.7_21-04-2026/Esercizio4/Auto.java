public class Auto {
    public String targa;
    public String modello;

    // Costruttore di default:
    public Auto(){
        this.targa = "Non disponibile";
        this.modello = "Non disponibile";
    }
    // Costruttore
    public Auto(String targa, String modello) {
        this.targa = targa;
        this.modello = modello;
    }
}
