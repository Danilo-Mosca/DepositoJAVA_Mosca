public class Rivista extends Risorsa {
    private int numeroRivista;

    public Rivista(int numeroRivista, String titolo, int annoPubblicazione, String codice) {
        super(titolo, annoPubblicazione, codice);
        this.numeroRivista = numeroRivista;
    }

    public int getNumeroRivista() {
        return this.numeroRivista   ;
    }

    public void setNumeroRivista(int numeroRivista) {
        this.numeroRivista = numeroRivista;
    }
    
    @Override
    public void visualizzaDettagli() {
        System.out.println("Numero di rivista: " + getNumeroRivista () + " - Titolo: " + getTitolo() + " - Anno di pubblicazione: " + getAnnoPubblicazione() + " - Codice: " + getCodice());
    }
    
}
