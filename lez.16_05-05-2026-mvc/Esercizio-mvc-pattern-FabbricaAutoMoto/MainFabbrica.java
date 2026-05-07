import java.util.Scanner;

import controller.FabbricaController;
import view.ConsoleView;

public class MainFabbrica {
    public static void main(String[] args) {
        // Creo una istanza della View, che visualizzerà tutto in console
        ConsoleView view = new ConsoleView();
        // Creo un controller a cui non passerò come parametro il model, ma lo creerò
        // dentro il suo costruttore,
        // questo perchè il model è della classe S_Fabbrica che a sua volta è sia un
        // Singleton (istanza unica)
        // che il Subject (osservato) per gli Observer
        FabbricaController controller = new FabbricaController(view);

        Scanner scanner = new Scanner(System.in); // Creo lo Scanner per l'input dell'utente
        boolean running = true; // Variabile di controllo del ciclo
        String scelta;

        do {
            System.out.println("===== FABBRICA VEICOLI =====");
            System.out.println("1. Crea un'Auto");
            System.out.println("2. Crea una Moto");
            System.out.println("3. Mostra tutti i Veicoli");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");

            scelta = scanner.nextLine();
            // Variabili booleane di controllo tipologia Veicolo e aggiunta decoratori
            boolean isAuto;
            boolean verniciatura = false;
            boolean navigatore = false;

            switch (scelta) {

                case "1":
                    isAuto = true;
                    System.out.println("--- Configurazione Auto ---");

                    String rispostaNavigatoreAuto = "";
                    String rispostaVerniciaturaAuto = "";
                    do {
                        System.out.print("All'auto vuoi aggiungere il navigatore? (si/no): ");
                        rispostaNavigatoreAuto = scanner.nextLine();

                        if (rispostaNavigatoreAuto.equalsIgnoreCase("si")) {
                            navigatore = true;
                        } else if (rispostaNavigatoreAuto.equalsIgnoreCase("no")) {
                            navigatore = false;
                        } else {
                            System.out.println("Errore: inserisci 'si' o 'no'");
                        }

                    } while (!rispostaNavigatoreAuto.equalsIgnoreCase("si") &&
                            !rispostaNavigatoreAuto.equalsIgnoreCase("no"));

                    do {
                        System.out.print("All'auto vuoi aggiungere la verniciatura sportiva? (si/no): ");
                        rispostaVerniciaturaAuto = scanner.nextLine();

                        if (rispostaVerniciaturaAuto.equalsIgnoreCase("si")) {
                            verniciatura = true;
                        } else if (rispostaVerniciaturaAuto.equalsIgnoreCase("no")) {
                            verniciatura = false;
                        } else {
                            System.out.println("Errore: inserisci 'si' o 'no'");
                        }

                    } while (!rispostaVerniciaturaAuto.equalsIgnoreCase("si") &&
                            !rispostaVerniciaturaAuto.equalsIgnoreCase("no"));

                    controller.creaVeicoloConDecorator(isAuto, verniciatura, navigatore);
                    break;

                case "2":
                    isAuto = false;
                    System.out.println("--- Configurazione Moto ---");

                    String rispostaNavigatoreMoto = "";
                    String rispostaVerniciaturaMoto = "";

                    do {
                        System.out.print("Alla moto vuoi aggiungere il navigatore? (si/no): ");
                        rispostaNavigatoreMoto = scanner.nextLine();

                        if (rispostaNavigatoreMoto.equalsIgnoreCase("si")) {
                            navigatore = true;
                        } else if (rispostaNavigatoreMoto.equalsIgnoreCase("no")) {
                            navigatore = false;
                        } else {
                            System.out.println("Errore: inserisci 'si' o 'no'");
                        }

                    } while (!rispostaNavigatoreMoto.equalsIgnoreCase("si") &&
                            !rispostaNavigatoreMoto.equalsIgnoreCase("no"));

                    do {
                        System.out.print("Alla moto vuoi aggiungere la verniciatura sportiva? (si/no): ");
                        rispostaVerniciaturaMoto = scanner.nextLine();

                        if (rispostaVerniciaturaMoto.equalsIgnoreCase("si")) {
                            verniciatura = true;
                        } else if (rispostaVerniciaturaMoto.equalsIgnoreCase("no")) {
                            verniciatura = false;
                        } else {
                            System.out.println("Errore: inserisci 'si' o 'no'");
                        }

                    } while (!rispostaVerniciaturaMoto.equalsIgnoreCase("si") &&
                            !rispostaVerniciaturaMoto.equalsIgnoreCase("no"));

                    controller.creaVeicoloConDecorator(isAuto, verniciatura, navigatore);
                    break;

                case "3":
                    controller.caricaVeicoli();
                    break;

                case "4":
                    running = false;
                    System.out.println("Uscita dal programma");
                    break;

                default:
                    System.out.println("Scelta non valida!");
                    break;
            }

        } while (running);

        scanner.close(); // chiudo lo scanner
    }
}