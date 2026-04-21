/* TESTO ESERCIZIO
Costruttori
- Creare una Classe Persona con un Costruttore
- Definisci una classe Persona con attributi: nome, età, città.
- Crea due oggetti persona e mostra i loro dettagli.
*/

public class Persona {
    String nome;
    int eta;
    String citta;

    // Costruttore di default:
    public Persona(){
        nome = "Nessuna identità inserita";
        eta = -1;
        citta = "Non disponibile";
    }

    // Costruttore con parametri:
    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
        this.citta = "Non disponibile";
    }
    
    // Costruttore con parametri:
    public Persona(String nome, int eta, String citta) {
        this.nome = nome;
        this.eta = eta;
        this.citta = citta;
    }

    // Costruttore con parametri alternati:
    public Persona(String nome, String  citta, int eta) {
        this.nome = nome;
        this.eta = eta;
        this.citta = citta;
    }

    // Metodi
    public void mostraPersona() {
        System.out.println("Nome: " + nome + "\nEtà: " + eta + "\nCittà: " + citta);
    }
}
