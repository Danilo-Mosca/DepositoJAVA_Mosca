// Classe concreta che estende la classe astratta MessageDecorator e aggiunge il decoratore al messaggio
public class UppercaseDecorator extends MessageDecorator{
    // Costruttore
    public UppercaseDecorator(Message message){
        super(message);
    }

    // Override dei metodi che "TimestampDecorator" eredita da "MessageDecorator" che a sua volta implementa da "Message"
    
    // Metodo che setta e ritorna tutto il messaggio in maiuscolo
    @Override
    public String getContenuto(String contenuto) {
        return this.decoratedMessage.getContenuto(contenuto.toUpperCase());
    }
}