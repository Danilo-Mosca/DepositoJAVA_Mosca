import java.util.Scanner;

import controller.ComputerController;
import model.ComputerFacade;
import model.SistemaOperativoContext;
import model.SistemaOperativoStrategy;
import model.strategy.StrategyLinux;
import model.strategy.StrategyMacOs;
import model.strategy.StrategyWindows;
import view.ComputerView;

public class Main {
    public static void main(String[] args) {

        /***** TEST MAIN SENZA MENU E INPUT UTENTE *****/
        // Creo la STRATEGY concreta
        // SistemaOperativoStrategy os = new StrategyMacOs(); //Creo la STRATEGY
        // concreta e istanzio un sistema operativo (in questo caso MacOS)

        // Creo il CONTEXT della Strategy
        // SistemaOperativoContext context = new SistemaOperativoContext(os);

        // Creo il FACADE
        // ComputerFacade computer = new ComputerFacade(context);

        // MVC

        // Creo la VIEW
        // ComputerView view = new ComputerView();

        // Creo il CONTROLLER
        // ComputerController controller = new ComputerController(computer, view);

        // Avvio
        // controller.avvia();
        /***** FINE TEST MAIN SENZA MENU E INPUT UTENTE *****/

        Scanner scanner = new Scanner(System.in); // Creo lo Scanner per l'input dell'utente
        boolean continua = true; // Variabile di controllo del ciclo

        while (continua) {
            System.out.println("=== SIMULATORE AVVIO COMPUTER ===");
            System.out.println("Scegli un sistema operativo:");
            System.out.println("1. Windows");
            System.out.println("2. MacOS");
            System.out.println("3. Linux");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");

            String sceltaUtente = scanner.nextLine();

            // Creo la STRATEGY concreta inizializzandola a null per poi istanziarla con il
            // sistema operativo scelto dall'utente
            SistemaOperativoStrategy os = null;

            switch (sceltaUtente) {
                case "1":
                    // istanzio la strategy con Windows
                    os = new StrategyWindows();
                    break;
                case "2":
                    // istanzio la strategy con MacOs
                    os = new StrategyMacOs();
                    break;
                case "3":
                    // istanzio la strategy con Linux
                    os = new StrategyLinux();
                    break;
                case "4":
                    continua = false;
                    System.out.println("Uscita dal programma");
                    continue;
                default:
                    System.out.println("Scelta non valida!");
                    continue;
            }

            // Strategy + Context
            SistemaOperativoContext context = new SistemaOperativoContext(os);

            // Facade
            ComputerFacade computer = new ComputerFacade(context);

            // MVC
            ComputerView view = new ComputerView();
            ComputerController controller = new ComputerController(computer, view);

            // Avvio
            controller.avvia();
        }

        scanner.close(); // Chiudo lo scanner
    }
}