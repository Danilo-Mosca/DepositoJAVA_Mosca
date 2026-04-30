// Observer: osservatore concreto
public class Utente implements Observer {
    private String nome;
    private String cognome;

    public Utente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    // Override dei metodi nell'interfaccia:
    @Override
    public void aggiornamento(String messaggio) {
        System.out.println(this.nome + " " + this.cognome + " ha ricevuto una notifica: " + messaggio);
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getCognome() {
        return this.cognome;
    }
}