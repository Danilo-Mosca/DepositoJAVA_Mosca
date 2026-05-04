// Observer concreto, classe concreta che implementa l'interfaccia Observer
public class Utente implements Observer {
    private String nome;
    private String cognome;
    private Message messaggio;

    // Costruttore
    public Utente(String nome, String cognome, Message messaggio) {
        this.nome = nome;
        this.cognome = cognome;
        this.messaggio = messaggio;
    }

    // Override dei metodi nell'interfaccia
    @Override
    public void update(String messaggioParametro){
        this.messaggio.getContenuto(messaggioParametro);
        System.out.println(this.nome + " " + this.cognome + " messaggio: " + messaggio.getContenuto(
                messaggioParametro));
    }
}