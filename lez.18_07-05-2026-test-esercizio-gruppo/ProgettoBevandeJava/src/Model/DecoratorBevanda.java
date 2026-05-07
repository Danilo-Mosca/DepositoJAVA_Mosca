package Model;
//Decorator bevanda astratta
public abstract class DecoratorBevanda implements Bevanda {
    protected Bevanda bevanda;
    //costruttore
    public DecoratorBevanda(Bevanda bevanda) {
        this.bevanda = bevanda;
    }
    //metodo astratto per applicare la decorazione
    public abstract Bevanda applica(Bevanda bevanda);
    // metodi override
    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione();
    }
    @Override
    public double getCosto() {
        return bevanda.getCosto();
    }   
}
