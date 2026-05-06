// Facade
public class GestioneLuciFacade {
    private LuceCamera camera;
    private LuceCucina cucina;

    // Costruttore
    public GestioneLuciFacade(){
        camera = new LuceCamera();
        cucina = new LuceCucina();
    }

    public void accendiTutte(){
        camera.accendi();
        cucina.accendi();
    }    
}