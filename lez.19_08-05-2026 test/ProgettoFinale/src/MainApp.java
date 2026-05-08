import controller.*;
import view.ConsoleView;

public class MainApp {

    public static void main(String[] args) {

        // Service per gli OBSERVER
        TicketService service = new TicketService();

        // Registrazione delle notifiche
        service.addObserver(new UserObserver());
        service.addObserver(new AdminObserver());

        // Facade
        TicketFacade facade = new TicketFacade(service);
        // Controller
        TicketController controller = new TicketController(facade);

        // View
        ConsoleView view = new ConsoleView(controller);

        // Avvio dell'applicazione
        view.start();
    }
}