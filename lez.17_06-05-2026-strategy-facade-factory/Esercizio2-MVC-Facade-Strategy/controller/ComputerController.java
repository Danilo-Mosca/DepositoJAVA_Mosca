package controller;
// CONTROLLER collega Model e View

import model.ComputerFacade;
import view.ComputerView;

public class ComputerController {
    private ComputerFacade computerFacade;
    private ComputerView view;

    // Costruttore
    public ComputerController(ComputerFacade computerFacade, ComputerView view) {
        this.computerFacade = computerFacade;
        this.view = view;
    }

    public void avvia() {
        view.mostraMessaggio("Accensione del computer");
        computerFacade.accendiComputer();
        view.mostraMessaggio("Il computer è pronto per l'utilizzo");
    }
}