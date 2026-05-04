// Classe concreta che estende la classe astratta MessageDecorator e aggiunge il decoratore al messaggio
public class EmojiDecorator extends MessageDecorator{
    // Costruttore
    public EmojiDecorator(Message message) {
        super(message);
    }

    // Override dei metodi che "TimestampDecorator" eredita da "MessageDecorator"
    // che a sua volta implementa da "Message"

    // Metodo che aggiunge al messaggio emoji e lo ritorna
    @Override
    public String getContenuto(String contenuto) {
        return this.decoratedMessage.getContenuto(contenuto + " 👋 😊👍");
    }
}