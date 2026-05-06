public class LuceCucina implements Strategy{
    void accendi() {
        System.out.println("Luce della cucina accesa!");
    }

    // Override dei metodi dello Strategy
    @Override
    public void coloreLuce() {
        System.out.println("La luce della cucina è di colore bianco");
    }

    @Override
    public void durataAccensione(){
        System.out.println("La luce della cucina si spegne dopo 10 minuti");
    }
}