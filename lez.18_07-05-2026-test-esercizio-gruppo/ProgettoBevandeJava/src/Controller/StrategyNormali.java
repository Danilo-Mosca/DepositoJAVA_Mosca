package Controller;
import Model.Bevanda;
//Strategy per persone normali
public class StrategyNormali implements StrategySconti {

    @Override
    public double processaSconti(Bevanda bevanda) {
        double costo = bevanda.getCosto();
        return costo;
    }

    
}
