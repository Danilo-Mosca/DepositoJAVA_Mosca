import java.util.ArrayList;

public class Biblioteca {
    private String name;
    private ArrayList<Risorsa> risorse;
    private ArrayList<Utente> utenti;

    public Biblioteca(String name) {
        this.name = name;
        this.risorse = new ArrayList<>();
        this.utenti = new ArrayList<>();
    }

    // getter risorse e utenti:
    public ArrayList<Risorsa> getRisorse() {
        return this.risorse;
    }

    public ArrayList<Utente> getUtenti() {
        return this.utenti;
    }

    // Metodi:
    public void aggiungiRisorsa(Risorsa r) {
        risorse.add(r);
    }

    public void aggiungiUtente(Utente u) {
        utenti.add(u);
    }

    public void stampaRisorse() {
        System.out.println("Risorse disponibili in " + this.name);
        if(risorse.size() > 0){
            for (Risorsa risorsa : risorse) {
                // risorsa.visualizzaDettagli();            // Non serve più! Ho fatto l'override del metodo toString() nella classe padre astratta Risorsa
                System.out.println(risorsa);                // rappresentazione testuale dell’oggetto risorsa: mostra il metodo toString() ereditato dalla classe padre
            }
        }
        else {
            System.out.println("Non ci sono risore disponibili!");
        }
    }

    public void stampaRisorsa(String titolo) {
        for (Risorsa risorsa : risorse) {
            if (risorsa.getTitolo().equalsIgnoreCase(titolo)) {
                // risorsa.visualizzaDettagli();        // Come stampaRisorse()
                System.out.println(risorsa);            // Come stampaRisorse()
            }
        }
        System.out.println("Risorsa non trovata");
    }

    public void stampaUtenti(){
        System.out.println("Utenti registrati presso la : " + this.name);
        if (utenti.size() > 0) {
            for(Utente utente : utenti){
                System.out.println("Id utente: " + utente.getIdUtente() + " - Nome: " + utente.getNome());
            }
        }
        else {
            System.out.println("Non ci sono utenti registrati!");
        }
    }
}
