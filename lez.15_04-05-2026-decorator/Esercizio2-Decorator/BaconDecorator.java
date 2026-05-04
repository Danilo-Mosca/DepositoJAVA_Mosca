// Classe concreta "BaconDecorator" che estende la classe astratta decorator "HamburgerDecorator"
public class BaconDecorator extends HamburgerDecorator {
    // Costruttore
    public BaconDecorator(Hamburger hamburger) {
        super(hamburger);
    }

    // Override dei metodi che HamburgerDecorator implementa da Hamburger
    @Override
    public String getDescrizione() {
        return this.hamburgerDecorated.getDescrizione() + " con bacon!";
    }

    @Override
    public double getPrezzo() {
        return this.hamburgerDecorated.getPrezzo() + 0.80;
    }
}