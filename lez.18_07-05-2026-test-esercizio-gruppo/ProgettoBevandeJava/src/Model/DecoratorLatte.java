package Model;

public class DecoratorLatte extends DecoratorBevanda {
    //costruttore
    public DecoratorLatte(Bevanda bevanda) {
        super(bevanda);
    }
    //metodo override
    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + ", con Latte";
    }
    @Override
    public double getCosto() {
        double costo = bevanda.getCosto() + 0.2d;
        return Math.round(costo * 100.0) / 100.0;
    }
    // metodo per applicare la decorazione
    @Override
    public Bevanda applica(Bevanda bevanda) {
        return new DecoratorLatte(bevanda);
    }
}
