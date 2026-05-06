// Strategie concrete, implementazioni concrete di SistemaOperativoStrategy
public class StrategyWindows implements SistemaOperativoStrategy {
    @Override
    public void avvia() {
        System.out.println("Avvio il sistema operativo Windows");
    }
}