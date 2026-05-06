// CONTROLLER collega Model e View
public class Controller {
    private Facade computerFacade = new Facade();
    private View view = new View();
    
    // Costruttore
    public Controller(Facade computerFacade, View view){
        this.computerFacade = computerFacade;
        this.view = view;
    }

    public void avvia() {
        view.mostraMessaggio("Accensione del");
        computerFacade.accendiComputer();
        view.mostraMessaggio("Il computer è pronto per l'utilizzo");
    }
}
