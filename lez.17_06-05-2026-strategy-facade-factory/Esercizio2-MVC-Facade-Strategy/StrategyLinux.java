// Strategie concrete, implementazioni concrete di SistemaOperativoStrategy
public class StrategyLinux implements SistemaOperativoStrategy {
    @Override
    public void avvia() {
        System.out.println("Avvio il sistema operativo Linux");
    }
}