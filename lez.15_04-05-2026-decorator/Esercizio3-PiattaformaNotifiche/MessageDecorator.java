// Classe astratta MessageDecorator che implementa l'interfaccia Message
public abstract class MessageDecorator implements Message {
    protected Message decoratedMessage;

    // Costruttore
    public MessageDecorator(Message message) {
        this.decoratedMessage = message;
    }

    // Sovrascrivo i metodi dell'interfaccia Message:
    @Override
    public String getContenuto(String contenuto) {
        return this.decoratedMessage.getContenuto(contenuto);
    }
}