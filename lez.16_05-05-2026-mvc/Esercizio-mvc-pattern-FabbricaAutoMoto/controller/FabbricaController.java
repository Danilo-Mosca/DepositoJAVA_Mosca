package controller;
// Classe CONTROLLER (collega Model e View)

import model.Auto;
import model.Moto;
import model.Navigatore;
import model.S_Fabbrica;
import model.Veicolo;
import model.VerniciaturaSportiva;
import view.ConsoleView;

public class FabbricaController {
    private ConsoleView view;
    private S_Fabbrica model;

    // Costruttore che inizializza le variabili view e controller. Non ho bisogno di
    // passargli anche il parametro S_Fabbrica perchè questo è un'istanza unica, ne
    // esiste soltanto una, quindi per assegnarlo al model mi basta semplicemente
    // richiamare il suo metodo statico getIstanza()
    public FabbricaController(ConsoleView view) {
        this.view = view;
        this.model = S_Fabbrica.getIstanza();
        // Aggiorno la view con un nuovo Observer
        model.addObserver(view);            // Observer: la view viene notificata automaticamente
    }

    // Metodo che crea un'Auto base
    public void creaAutoBase() {
        // Aggiungo un nuovo oggetto Auto richiamando il metodo produciVeicolo() della
        // classe "S_Fabbrica" che a sua volta lo aggiungerà all'arraylist di
        // listaVeicoli
        model.produciVeicolo(new Auto());
    }

    // Metodo che crea una Moto base
    public void creaMotoBase() {
        // Aggiungo un nuovo oggetto Moto richiamando il metodo produciVeicolo() della
        // classe "S_Fabbrica" che a sua volta lo aggiungerà all'arraylist di
        // listaVeicoli
        model.produciVeicolo(new Moto());
    }

    // Metodo che crea un decoratore per il Veicolo aggiungengo dinamicamente il Decoratore scelto dall'utente, ovvero se aggiungere al veicolo
    // un navigatore o una verniciatura sportiva
    public void creaVeicoloConDecorator(boolean isAuto, boolean verniciatura, boolean navigatore){
        // Controllo un Veicolo vuoto
        Veicolo veicolo;
        // Prima verifico se ho passato come parametro un auto o una moto e di conseguenza creo il relativo oggetto base
        if (isAuto) {
            veicolo = new Auto();
        }
        else {
            veicolo = new Moto();
        }
        // Poi controllo se l'utente ha aggiunto la verniciatura sportiva o meno e ci aggiungo il relativo decorator
        if (verniciatura) {
            veicolo = new VerniciaturaSportiva(veicolo);
        }
        // Poi controllo se l'utente ha aggiunto il navigatore o meno e ci aggiungo il relativo decoratore
        if (navigatore) {
            veicolo = new Navigatore(veicolo);
        }
        // Infine salvo il veicolo nella Fabbrica
        model.produciVeicolo(veicolo);
    }
    
    // Metodo che mostra tutti i veicoli
    // Non crea dati, non modifica dati, prende semplicemente i dati dal Model e li passa alla View, fa da coordinamento (se lo spostassi nella view violerei il principio di separazione delle responsabilità)
    public void caricaVeicoli(){
        // Richiamo il metodo mostraVeicoli() della View a cui passerà come paramentro il model.
        // Prendi i veicoli dalla fabbrica e passali alla view per stamparli
        // Passa i veicoli alla view per la visualizzazione
        view.mostraVeicoli(model.getVeicoli());
    }
}