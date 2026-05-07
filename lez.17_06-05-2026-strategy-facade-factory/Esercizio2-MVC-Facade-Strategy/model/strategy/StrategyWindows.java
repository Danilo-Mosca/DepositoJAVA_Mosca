package model.strategy;
// Strategie concrete, implementazioni concrete di SistemaOperativoStrategy

import model.SistemaOperativoStrategy;

public class StrategyWindows implements SistemaOperativoStrategy {
    @Override
    public void avvia() {
        System.out.println("Avvio il sistema operativo Windows");
    }
}