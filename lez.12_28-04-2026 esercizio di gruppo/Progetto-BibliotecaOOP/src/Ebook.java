public class Ebook extends Risorsa {
    private String formato;

    public Ebook(String formato, String titolo, int annoPubblicazione, String codice) {
        super(titolo, annoPubblicazione, codice);
        this.formato = formato;
    }

    public String getFormato() {
        return this.formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
    
    @Override
    public void visualizzaDettagli() {
        System.out.println("Formato: " + getFormato() + " - Titolo: " + getTitolo() + " - Anno di pubblicazione: " + getAnnoPubblicazione() + " - Codice: " + getCodice());
    }
    
}
