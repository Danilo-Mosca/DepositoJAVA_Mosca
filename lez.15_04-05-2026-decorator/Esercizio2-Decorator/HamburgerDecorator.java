// Classe astratta HambuegerDecorator che implementa l'interfaccia Hamburger
public abstract class HamburgerDecorator implements Hamburger{
    protected Hamburger hamburgerDecorated;

    // Costruttore
    public HamburgerDecorator(Hamburger hamburgerDecorated){
        this.hamburgerDecorated = hamburgerDecorated;
    }

    // Sovrascrivo i metodi dell'interfaccia Hamburger
    @Override
    public String getDescrizione() {
        return this.hamburgerDecorated.getDescrizione();
    }

    @Override
    public double getPrezzo() {
        return this.hamburgerDecorated.getPrezzo();
    }
}
