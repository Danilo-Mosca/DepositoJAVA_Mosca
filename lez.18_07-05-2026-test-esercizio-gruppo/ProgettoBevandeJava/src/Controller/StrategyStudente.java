package Controller;
import Model.Bevanda;
//Strategy per studente
public class StrategyStudente implements StrategySconti {

    @Override
    public double processaSconti(Bevanda bevanda) {
        double costo = bevanda.getCosto() * 0.80;
        return Math.round(costo * 100.0) / 100.0;
    }
    
}
