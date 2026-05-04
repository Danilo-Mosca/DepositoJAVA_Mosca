// Classe concreta dell'interfaccia Message
public class MessageBaseDecorator implements Message {
    // Override del metodo presente nell'interfaccia implementata:
    @Override
    public String getContenuto(String messaggio) {
        return messaggio;
    }
}