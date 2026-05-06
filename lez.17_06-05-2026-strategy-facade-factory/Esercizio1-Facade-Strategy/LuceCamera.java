public class LuceCamera implements Strategy{
    void accendiLuceCamera(){
        System.out.println("Luce della camera accesa!");
    }

    // Override del metodo dello Strategy
    @Override
    public void coloreLuce(){
        System.out.println("La luce è di colore giallo");
    }
}
