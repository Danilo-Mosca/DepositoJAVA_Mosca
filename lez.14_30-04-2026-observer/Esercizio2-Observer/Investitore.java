// Interfaccia "Investitore" degli Observer, gli interessati, gli osservatori
public interface Investitore {
    void notifica(String azione, double valore);
    
    String getName();
}