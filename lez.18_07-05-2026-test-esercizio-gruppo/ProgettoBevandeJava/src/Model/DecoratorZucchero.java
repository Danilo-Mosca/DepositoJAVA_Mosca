package Model;

public class DecoratorZucchero extends DecoratorBevanda {
    //costruttore
    public DecoratorZucchero(Bevanda bevanda) {
        super(bevanda);
    }
    //metodo override
    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + ", con Zucchero";
    }
    @Override
    public double getCosto() {
        double costo = bevanda.getCosto() + 0.1d;
        return Math.round(costo * 100.0) / 100.0;
    }
    // metodo per applicare la decorazione
    @Override
    public Bevanda applica(Bevanda bevanda) {
        return new DecoratorZucchero(bevanda);
    }
}
