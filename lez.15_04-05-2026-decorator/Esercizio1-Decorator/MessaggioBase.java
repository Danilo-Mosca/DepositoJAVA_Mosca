// Classe concreta dell'interfaccia Messaggio
public class MessaggioBase implements Messaggio{
    
    // Override del metodo presente nell'interfaccia implementata:
    @Override
    public String getContenuto(String messaggio){
        return messaggio;
    }
}
