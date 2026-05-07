
import Controller.MacchinettaController;
import java.util.Scanner;
import Controller.StrategyStudente;
import Controller.StrategyNormali;

public class MainEsercizioMacchinetta {
    public static void main(String[] args) {
        MacchinettaController macchinetta = new MacchinettaController();
        // scanner per le scelte
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        int scelta;
        // ciclo while con menu
        while (true) {
            // visualizza menu
            macchinetta.visualizzaMenu();
            // scelta
            scelta = intScanner.nextInt();
            switch (scelta) {
                case 1:
                    // crea nuova bevanda
                    // visualizza bevande disponibili
                    macchinetta.visualizzaBevande();
                    scelta = intScanner.nextInt();
                    // crea nuova bevanda
                    macchinetta.creaNuovaBevanda(scelta);
                    break;
                case 2:
                    // aggiungi ingrediente extra
                    // visualizza ingredienti disponibili
                    macchinetta.visualizzaIngredientiExtra();
                    scelta = intScanner.nextInt();
                    // aggiungi ingrediente extra
                    macchinetta.aggiungiIngredienteExtra(scelta);
                    break;
                case 3:
                    // visualizza bevanda corrente
                    macchinetta.visualizzaBevandaCorrente();
                    break;
                case 4:
                    // conferma ordine
                    // chiede per scontistica
                    System.out.println("Sei uno studente?(S/N)");
                    String sceltaStudente = stringScanner.next();
                    // scelta studente
                    if (sceltaStudente.equalsIgnoreCase("S")) {
                        // se è uno studente
                        macchinetta.setStrategy(new StrategyStudente());
                    } else {
                        // se è una persona normale
                        macchinetta.setStrategy(new StrategyNormali());
                    }
                    // conferma ordine
                    macchinetta.confermaOrdine();
                    break;
                case 5:
                    // visualizza storico
                    macchinetta.visualizzaStorico();
                    break;
                case 6:
                    // esci
                    intScanner.close();         // Chiudo lo scanner
                    stringScanner.close();      // Chiudo lo scanner
                    return;
                default:
                    // se scelta non valida
                    System.out.println("Scelta non valida");
                    break;
            }
        }
    }
}