public class LuceCamera implements Strategy{
    void accendi(){
        System.out.println("Luce della camera accesa!");
    }

    // Override dei metodi dello Strategy
    @Override
    public void coloreLuce(){
        System.out.println("La luce della camera è di colore caldo");
    }

    @Override
    public void durataAccensione() {
        System.out.println("La luce della camera si spegne dopo 5 minuti");
    }
}