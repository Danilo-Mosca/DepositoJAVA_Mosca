// Decoratore concreto
public class DecoratoreMaiuscolo extends Decorator {
    protected Messaggio messaggio;

    // Costruttore
    public DecoratoreMaiuscolo(Messaggio messaggio) {
        super(messaggio);
    }

    // Sovrascrivo i metodi dell'interfaccia Messaggio
    @Override
    public String getContenuto(String messaggio) {
        super.getContenuto(messaggio);
        return messaggio.toUpperCase();
    }
}