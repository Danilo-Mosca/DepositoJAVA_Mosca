public class LuceCucina implements Strategy{
    void accendiLuceCucina() {
        System.out.println("Luce della cucina accesa!");
    }

    // Override del metodo dello Strategy
    @Override
    public void coloreLuce() {
        System.out.println("La luce è di colore bianco");
    }
}
