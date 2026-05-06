// Strategie concrete, implementazioni concrete di SistemaOperativoStrategy
public class StrategyMacOs implements SistemaOperativoStrategy {
    @Override
    public void avvia() {
        System.out.println("Avvio il sistema operativo MacOS");
    }
}