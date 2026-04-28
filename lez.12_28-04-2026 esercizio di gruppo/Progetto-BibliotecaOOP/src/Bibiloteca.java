import java.util.ArrayList;

public class Bibiloteca {
    private String name;
    private ArrayList<Risorsa> risorse;
    private ArrayList<Utente> utenti;

    public Bibiloteca(String name) {
        this.name = name;
        this.risorse = new ArrayList<>();
        this.utenti = new ArrayList<>();
    }

    // getter risore e utenti:
    public ArrayList<Risorsa> getRisorse() {
        return risorse;
    }

    public ArrayList<Utente> getUtenti() {
        return utenti;
    }

    // Metodi:
    public void aggiungiRisorsa(Risorsa r) {
        risorse.add(r);
    }

    public void aggiungiUtente(Utente u) {
        utenti.add(u);
    }

    public void stampaRisorse() {
        System.out.println("Risorse disponibili in " + name);
        for (Risorsa risorsa : risorse) {
            risorsa.visualizzaDettagli();
        }
    }

    public void stampaRisorsa(String titolo) {
        for (Risorsa risorsa : risorse) {
            if (risorsa.getTitolo().equalsIgnoreCase(titolo)) {
                risorsa.visualizzaDettagli();
            }
        }
        System.out.println("Risorsa non trovata");
    }
}
