// Observer: osservatore concreto
public class Utente implements Observer {
    private String nome;
    private String cognome;

    public Utente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    @Override
    public void aggiornamento(String messaggio) {
        System.out.println(this.nome + " " + this.cognome + " ha ricevuto una notifica: " + messaggio);
    }

    public String getnome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }
}
