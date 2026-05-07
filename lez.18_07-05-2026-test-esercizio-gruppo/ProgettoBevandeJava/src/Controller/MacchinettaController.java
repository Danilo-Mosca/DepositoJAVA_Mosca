package Controller;

import Model.*;
import View.MacchinettaView;

/**
 * Controller del sistema Macchinetta.
 * Si occupa di gestire il flusso dell'applicazione:
 * - riceve input dall'utente (dal Main)
 * - chiama il Model (Facade + Decorator + Singleton)
 * - aggiorna la View
 */

public class MacchinettaController {

    // Facade: semplifica l'accesso alla logica del Model
    private BarFacade facade;
    // View: responsabile della stampa a video
    private MacchinettaView view;
    // Bevanda attualmente in costruzione (stato corrente)
    private Bevanda bevandaCorrente;
    // Strategy opzionale per applicare sconti o logiche aggiuntive
    private StrategySconti strategy;

    /**
     * Costruttore:
     * inizializza Facade e View
     */
    public MacchinettaController() {
        this.facade = new BarFacade();
        this.view = new MacchinettaView();
    }

    /**
     * Setter per la Strategy (Pattern Strategy)
     * Permette di cambiare dinamicamente la logica di sconto
     */
    // Strategy setter
    public void setStrategy(StrategySconti strategy) {
        this.strategy = strategy;
    }

    // MENU
    // Mostra il menu principale all'utente
    public void visualizzaMenu() {
        view.visualizzaMenu();
    }

    // Mostra le bevande disponibili
    public void visualizzaBevande() {
        view.visualizzaBevande();
    }

    // Mostra gli ingredienti extra disponibili
    public void visualizzaIngredientiExtra() {
        view.visualizzaIngredientiExtra();
    }

    // BEVANDA BASE
    // Crea una nuova bevanda base tramite Facade in base alla scelta utente
    public void creaNuovaBevanda(int scelta) {

        switch (scelta) {
            case 1:
                bevandaCorrente = facade.creaCaffe();
                break;
            case 2:
                bevandaCorrente = facade.creaTe();
                break;
            case 3:
                bevandaCorrente = facade.creaCioccolata();
                break;
            default:
                System.out.println("Scelta non valida");
                return;
        }

        view.visualizzaBevandaCorrente(bevandaCorrente);
    }

    // EXTRA (DECORATOR)
    /**
     * Aggiunge un ingrediente extra alla bevanda corrente
     * usando il pattern Decorator. Parametri dell'utente: ingrediente selezionato
     */
    public void aggiungiIngredienteExtra(int scelta) {

        // Controllo stato
        if (bevandaCorrente == null) {
            System.out.println("Devi prima creare una bevanda!");
            return;
        }

        // Applicazione Decorator dinamico
        switch (scelta) {

            case 1:
                bevandaCorrente = new DecoratorLatte(bevandaCorrente);
                break;

            case 2:
                bevandaCorrente = new DecoratorCannella(bevandaCorrente);
                break;

            case 3:
                bevandaCorrente = new DecoratorCacao(bevandaCorrente);
                break;

            case 4:
                bevandaCorrente = new DecoratorPanna(bevandaCorrente);
                break;

            case 5:
                bevandaCorrente = new DecoratorZucchero(bevandaCorrente);
                break;

            default:
                System.out.println("Ingrediente non valido");
                return;
        }

        // Aggiorna la vista
        view.visualizzaBevandaCorrente(bevandaCorrente);
    }

    // ORDINE (SINGLETON + STRATEGY)
    /**
     * Conferma l'ordine corrente:
     * - salva tramite Singleton
     * - stampa conferma
     * - applica eventuale Strategy (sconti)
     */
    public void confermaOrdine() {

        if (bevandaCorrente == null) {
            System.out.println("Nessuna bevanda da confermare");
            return;
        }

        // Salvataggio ordine tramite Singleton
        facade.archiviaOrdine(bevandaCorrente);
        // Conferma visuale ordine
        view.confermaOrdine(bevandaCorrente);
        // Applicazione Strategy opzionale (es: sconti)
        if (strategy != null) {
            double prezzoFinale = strategy.processaSconti(bevandaCorrente);
            view.visualizzaMessaggio("Prezzo finale con eventuali sconti: " + prezzoFinale);
        }
        // Reset bevanda per nuovo ordine
        bevandaCorrente = null;
    }

    // STORICO
    /**
     * Visualizza lo storico degli ordini
     * recuperandolo dal Facade
     */
    public void visualizzaStorico() {
        view.visualizzaStorico(facade.stampaStorico());
    }

    // GETTER (opzionale debug)
    /**
     * Restituisce la bevanda corrente (utile per debug o test)
     */
    public Bevanda getBevandaCorrente() {
        return bevandaCorrente;
    }

    // Mostra la bevanda corrente tramite View
    public void visualizzaBevandaCorrente() {
        view.visualizzaBevandaCorrente(getBevandaCorrente());
    }
}