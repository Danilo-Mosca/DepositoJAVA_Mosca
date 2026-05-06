public class Main {
    public static void main(String[] args) {
        // Creo la STRATEGY concreta
        SistemaOperativoStrategy os = new StrategyMacOs(); //Creo la STRATEGY conctreta e istanzio un sistema operativo (in questo caso MacOS)
        
        // Creo il CONTEXT della Strategy
        SistemaOperativoContext context = new SistemaOperativoContext(os);

        // Creo il FACADE
        ComputerFacade computer = new ComputerFacade(context);

        // MVC

        // Creo la VIEW
        ComputerView view = new ComputerView();

        // Creo il CONTROLLER
        ComputerController controller = new ComputerController(computer, view);

        // Avvio
        controller.avvia();
    }
}