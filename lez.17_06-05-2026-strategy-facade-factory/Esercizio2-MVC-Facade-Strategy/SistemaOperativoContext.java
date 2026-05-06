public class SistemaOperativoContext {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void performTask() {
        strategy.avvia();
    }
}