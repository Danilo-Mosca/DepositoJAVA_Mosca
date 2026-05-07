package Model;

public class DecoratorPanna extends DecoratorBevanda {
    //costruttore
    public DecoratorPanna(Bevanda bevanda) {
        super(bevanda);
    }
    //metodo override
    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + ", con Panna";
    }
    @Override
    public double getCosto() {
        double costo = bevanda.getCosto() + 0.4d;
        return Math.round(costo * 100.0) / 100.0;
    }
    // metodo per applicare la decorazione
    @Override
    public Bevanda applica(Bevanda bevanda) {
        return new DecoratorPanna(bevanda);
    }
}
