public abstract class Risorsa {
    private String titolo;
    private int annoPubblicazione;
    private String codice;

    // Costruttore:
    public Risorsa(String titolo, int annoPubblicazione, String codice) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.codice = codice;
    }

    // Getter e setter:
    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public String getCodice() {
        return codice;
    }

    // Classe astratta che implementeranno le sottoclassi: Libro, Rivista, Ebook:
    public abstract String visualizzaDettagli();

    // Override del metodo toString()ereditato dalla classe Object:
    @Override
    public String toString(){
        // Richiamo qui dentro il metodo che sarà implementato singolarmente dalle sue sottoclassi
        // Così da poterlo visualizzare direttamente con un System.out.println(nomeOggetto):
        return visualizzaDettagli();
    }
}
