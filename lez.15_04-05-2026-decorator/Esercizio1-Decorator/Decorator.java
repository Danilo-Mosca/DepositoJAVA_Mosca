// Decoratore astratto
public abstract class Decorator implements Messaggio {
    protected Messaggio messaggio;

    // Costruttore
    public Decorator(Messaggio messaggio){
        this. messaggio = messaggio;
    }

    // Sovrascrivo i metodi dell'interfaccia Messaggio
    @Override
    public String getContenuto(String messaggio) {
        return this.messaggio.getContenuto(messaggio);
    }
}
