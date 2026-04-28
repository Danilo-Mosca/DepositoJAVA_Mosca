import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca("Biblioteca Centrale");

        boolean running = true;     // Variabile di controllo ciclo do while

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Aggiungi un Libro");
            System.out.println("2. Aggiungi una Rivista");
            System.out.println("3. Aggiungi un'Ebook");
            System.out.println("4. Aggiungi un Utente");
            System.out.println("5. Presta una Risorsa");
            System.out.println("6. Restituisci una Risorsa");
            System.out.println("7. Visualizza le Risorse");
            System.out.println("8. Visualizza gli utenti registrati");
            System.out.println("9. Visualizza le risorse prestate per Utente");
            System.out.println("10. Cerca una Risorsa dal titolo");
            System.out.println("0. Esci");

            System.out.print("Scelta: ");
            String scelta = scanner.nextLine();
            // scanner.nextLine();             //pulizia buffer

            switch (scelta) {

                case "1":
                    // Inserimeoto libro:
                    System.out.print("Titolo: ");
                    String titoloL = scanner.nextLine();

                    System.out.print("Anno: ");
                    int annoL = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Codice: ");
                    String codiceL = scanner.nextLine();

                    System.out.print("Autore: ");
                    String autore = scanner.nextLine();

                    // Aggiungo quella risorsa (in questo caso un "Libro") nell'ArrayList "risorse" della classe "Biblioteca":
                    biblioteca.aggiungiRisorsa(new Libro(autore, titoloL, annoL, codiceL));
                    break;

                case "2":
                    // Inserimeoto rivista:
                    System.out.print("Titolo: ");
                    String titoloR = scanner.nextLine();

                    System.out.print("Anno: ");
                    int annoR = scanner.nextInt();

                    System.out.print("Numero rivista: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Codice: ");
                    String codiceR = scanner.nextLine();

                    // Aggiungo quella risorsa (in questo caso una "Rivista") nell'ArrayList "risorse" della classe "Biblioteca":
                    biblioteca.aggiungiRisorsa(new Rivista(numero, titoloR, annoR, codiceR));
                    break;

                case "3":
                    // Inserimeoto ebook:
                    System.out.print("Titolo: ");
                    String titoloE = scanner.nextLine();

                    System.out.print("Anno: ");
                    int annoE = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Codice: ");
                    String codiceE = scanner.nextLine();

                    System.out.print("Formato: ");
                    String formato = scanner.nextLine();

                    // Aggiungo quella risorsa (in questo caso un "Ebook") nell'ArrayList "risorse" della classe "Biblioteca":
                    biblioteca.aggiungiRisorsa(new Ebook(formato, titoloE, annoE, codiceE));
                    break;

                case "4":
                    // Inserimento nuovo utente:
                    System.out.print("Nome utente: ");
                    String nome = scanner.nextLine();

                    // Aggiungo un nuovo utente nell'ArrayList "utenti" della classe "Biblioteca":
                    biblioteca.aggiungiUtente(new Utente(nome));
                    break;

                case "5":
                    // Presta una risorsa:
                    System.out.print("Titolo risorsa da prestare: ");
                    String titoloPrestito = scanner.nextLine();

                    System.out.print("Nome utente: ");
                    String nomeUtente = scanner.nextLine();

                    // Assegno alle due variabili di seguito le risorse da prestare all'utente "utentePrestito" sempre se quest'ultimo esista:
                    Risorsa risorsaDaPrestare = trovaRisorsa(biblioteca, titoloPrestito);
                    Utente utentePrestito = trovaUtente(biblioteca, nomeUtente);

                    // Se la risorsa esiste (non restituisce null) e anche l'utente esiste (non restituisce null):
                    if (risorsaDaPrestare != null && utentePrestito != null) {
                        // Allora richiamo il metodo prendiInPrestito() della classe Utente a cui passo la risorsa da prestare:
                        utentePrestito.prendiInPrestito(risorsaDaPrestare);
                    } else {
                        System.out.println("Errore: risorsa o utente non trovato");
                    }
                    break;

                case "6":
                    // Restituisci una risorsa:
                    System.out.print("Titolo risorsa da restituire: ");
                    String titoloRest = scanner.nextLine();

                    System.out.print("Nome utente: ");
                    String nomeRest = scanner.nextLine();

                    // Assegno alle due variabili di seguito le risorse da restituire dall'utente "utentePrestito" sempre se quest'ultimo esista:
                    Risorsa risorsaRest = trovaRisorsa(biblioteca, titoloRest);
                    Utente utenteRest = trovaUtente(biblioteca, nomeRest);

                    // Se la risorsa è stata realmente prestata (non restituisce null) e anche l'utente esiste (non restituisce null):
                    if (risorsaRest != null && utenteRest != null) {
                        // Allora richiamo il metodo restituisci() della classe Utente a cui passo la risorsa da restituire:
                        utenteRest.restituisci(risorsaRest);
                    } else {
                        System.out.println("Errore: risorsa o utente non trovato");
                    }
                    break;

                case "7":
                    // Stampa tutte le risorse:
                    biblioteca.stampaRisorse();
                    break;

                case "8":
                    // Stampa tutti gli utenti:
                    biblioteca.stampaUtenti();
                    break;

                case "9":
                    // Stampa i prestiti agli utenti:
                    System.out.print("Nome utente: ");          // Inserisco il nome dell'utente per il quale si vuole conoscere le risorse prestate
                    String nomeStampa = scanner.nextLine();

                    // Richiamo il metodo statico trovaUtente() per verificare se l'utente esiste:
                    Utente u = trovaUtente(biblioteca, nomeStampa);
                    // Se l'utente esiste:
                    if (u != null) {
                        u.stampaPrestiti();         // Stampo i prestiti ad esso associato
                    } else {
                        System.out.println("Utente non trovato");           // Altrimenti stampo il messaggio "Utente non trovato"
                    }
                    break;

                case "10":
                    // Cerca la risorsa inserendo un titolo:
                    System.out.print("Titolo da cercare: ");
                    String titolo = scanner.nextLine();
                    biblioteca.stampaRisorsa(titolo);
                    break;

                case "0":
                    // Esci dal programma:
                    running = false;        // Imposto la variabile di controllo a false per poter uscire dal ciclo
                    break;

                default:
                    // Inserimento scelta non valida:
                    System.out.println("Scelta non valida");
            }

        } while (running);

        scanner.close();
    }

    // METODI STATICI UTILIZZATI NELLO SWITCH DI SELEZIONE NEL MENU':

    // Metodo statico che ricerca la risorsa da dare in prestito o da restituire (richiamato appunto nell'opzione "5.Prestito Risorsa" e "6.Restituzione Risorsa"):
    public static Risorsa trovaRisorsa(Biblioteca biblioteca, String titolo) {
        for (Risorsa risorsa : biblioteca.getRisorse()) {
            if (risorsa.getTitolo().equalsIgnoreCase(titolo)) {
                return risorsa;
            }
        }
        return null;
    }

    // Metodo statico che restituisce l'utente inserito, se presente (richiamato nell'opzione "5.Prestito Risorsa", "6.Restituzione Risorsa" e "8.Stampa Prestiti Utente"):
    public static Utente trovaUtente(Biblioteca biblioteca, String nome) {
        for (Utente utente : biblioteca.getUtenti()) {
            if (utente.getNome().equalsIgnoreCase(nome)) {
                return utente;
            }
        }
        return null;
    }
}
