// Classe astratta MessageDecorator che implementa l'interfaccia Message
public abstract class MessageDecorator implements Message {
    protected Message decoratedMessage;

    // Costruttore
    public MessageDecorator(Message message) {
        this.decoratedMessage = message;
    }

    // Sovrascrivo i metodi dell'interfaccia Coffee:
    @Override
    public void setContent(String content) {
        this.decoratedMessage.setContent(content);
    }

    @Override
    public String getContent() {
        return this.decoratedMessage.getContent();
    }
}