// Decoratore base astratto che implementa l'interfaccia Veicolo
public abstract class VeicoloDecorator implements Veicolo{
    protected Veicolo veicolo;

    public VeicoloDecorator(Veicolo veicolo){
        this.veicolo = veicolo;
    }
}