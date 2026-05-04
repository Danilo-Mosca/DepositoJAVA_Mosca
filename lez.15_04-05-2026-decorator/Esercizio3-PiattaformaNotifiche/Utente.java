// Observer concreto, classe concreta che implementa l'interfaccia Observer
public class Utente implements Observer {
    private String nome;
    private String cognome;

    // Costruttore
    public Utente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    // Override dei metodi nell'interfaccia
    @Override
    public void update(String messaggio){
        System.out.println(this.nome + " " + this.cognome + " ha ricevuto una notifica: " + messaggio);
    }
}