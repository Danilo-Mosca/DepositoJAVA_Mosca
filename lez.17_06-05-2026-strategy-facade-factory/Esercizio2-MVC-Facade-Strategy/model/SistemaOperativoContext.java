package model;
// Context dello Strategy SistemaOperativoStrategy
public class SistemaOperativoContext {
    private SistemaOperativoStrategy strategy;

    // Costruttore
    public SistemaOperativoContext(SistemaOperativoStrategy strategy) {
        this.strategy = strategy;
    }

    // Altri metodi
    public void setStrategy(SistemaOperativoStrategy strategy) {
        this.strategy = strategy;
    }

    public void avviaSistema() {
        strategy.avvia();
    }
}