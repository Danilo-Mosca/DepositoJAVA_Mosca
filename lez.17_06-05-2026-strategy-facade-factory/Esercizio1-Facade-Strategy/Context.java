// Contesto dello Strategy
public class Context {
    private Strategy strategy;

    public void setStanza(Strategy strategy){
        this.strategy = strategy;
    }

    public void getColoreDurataLuce(){
        strategy.coloreLuce();
        strategy.durataAccensione();
    }
}