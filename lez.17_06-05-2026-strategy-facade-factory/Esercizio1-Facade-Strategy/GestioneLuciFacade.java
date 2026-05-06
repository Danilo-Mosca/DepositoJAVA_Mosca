public class GestioneLuciFacade {
    private LuceCamera camera = new LuceCamera();
    private LuceCucina cucina = new LuceCucina();

    public void accendiEntrambe(){
        camera.accendiLuceCamera();
        cucina.accendiLuceCucina();
    }    
}
