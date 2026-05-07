package Model;

public class DecoratorCannella extends DecoratorBevanda {   
    //costruttore
    public DecoratorCannella(Bevanda bevanda) {
        super(bevanda);
    }
    //metodo override
    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione() + ", con Cannella";
    }
    @Override
    public double getCosto() {
        double costo = bevanda.getCosto() + 0.3d;
        return Math.round(costo * 100.0) / 100.0;
    }
    // metodo per applicare la decorazione
    @Override
    public Bevanda applica(Bevanda bevanda) {
        return new DecoratorCannella(bevanda);
    }
}
