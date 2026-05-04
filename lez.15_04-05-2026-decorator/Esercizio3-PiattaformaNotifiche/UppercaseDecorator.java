// Classe concreta che estende la classe astratta MessageDecorator
public class UppercaseDecorator extends MessageDecorator{
    // Costruttore
    public UppercaseDecorator(Message message){
        super(message);
    }

    // Override dei metodi che "TimestampDecorator" eredita da "MessageDecorator" che a sua volta implementa da "Message"
    
    // Metodo che setta tutto il messaggio in maiuscolo
    @Override
    public void setContent(String content) {
        this.decoratedMessage.setContent(content.toUpperCase());
    }

    // Metodo che ritorna il messaggio modificato
    @Override
    public String getContent() {
        return this.decoratedMessage.getContent();
    }
}
