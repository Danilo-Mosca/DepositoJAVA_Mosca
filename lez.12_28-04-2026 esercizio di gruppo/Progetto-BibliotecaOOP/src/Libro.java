public class Libro extends Risorsa {
    private String autore;

    public Libro(String autore, String titolo, int annoPubblicazione, String codice) {
        super(titolo, annoPubblicazione, codice);
        this.autore = autore;
    }
    
    public String getAutore() {
        return this.autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }
    
    @Override
    public void visualizzaDettagli() {
        System.out.println("Autore: " + getAutore() + " - Titolo: " + getTitolo() + " - Anno di pubblicazione: " + getAnnoPubblicazione() + " - Codice: " + getCodice());
    }
}