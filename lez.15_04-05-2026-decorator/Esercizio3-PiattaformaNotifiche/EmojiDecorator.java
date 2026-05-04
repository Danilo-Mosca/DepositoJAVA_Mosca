// Classe concreta che estende la classe astratta MessageDecorator
public class EmojiDecorator extends MessageDecorator{
    // Costruttore
    public EmojiDecorator(Message message) {
        super(message);
    }

    // Override dei metodi che "TimestampDecorator" eredita da "MessageDecorator"
    // che a sua volta implementa da "Message"

    // Metodo che aggiunge al messaggio emoji
    @Override
    public void setContent(String content) {
        this.decoratedMessage.setContent(content + " 👋 😊👍");
    }

    // Metodo che ritorna il messaggio modificato
    @Override
    public String getContent() {
        return this.decoratedMessage.getContent();
    }
}
