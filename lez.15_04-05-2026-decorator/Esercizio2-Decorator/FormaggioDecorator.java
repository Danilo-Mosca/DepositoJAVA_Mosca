// Classe concreta "FormaggioDecorator" che estende la classe astratta decorator "HamburgerDecorator"
public class FormaggioDecorator extends HamburgerDecorator {
    // Costruttore
    public FormaggioDecorator(Hamburger hamburger) {
        super(hamburger);
    }

    // Override dei metodi che HamburgerDecorator implementa da Hamburger
    @Override
    public String getDescrizione() {
        return this.hamburgerDecorated.getDescrizione() + " con formaggio!";
    }

    @Override
    public double getPrezzo() {
        return this.hamburgerDecorated.getPrezzo() + 0.50;
    }
}