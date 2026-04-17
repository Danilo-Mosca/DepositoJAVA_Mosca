import java.util.ArrayList; // importo l'ArrayList per poterlo utilizzare nella classe
import java.util.Scanner; // Importo la classe Scanner

public class Gestionale {

    // Rendo la variabile contatoreOperazioni una variabile globale e statica (cioè appartenente alla classe non agli oggetti e quindi condivisa da tutto il programma:
    static int contatoreOperazioni = 0; 
    // contatore che controlla il numero di operazioni eseguite (a 4 operazioni vieni buttato fuori e bisogn riloggarsi)
    // Metodo principale "main" punto di accesso principale alla classe

    public static void main(String[] args) {
        ArrayList<String> usernames = new ArrayList<>();
        ArrayList<String> passwords = new ArrayList<>();
        ArrayList<String> cronologia = new ArrayList<>();

        Scanner scanner = new Scanner(System.in); // Crea un oggetto Scanner che permette l'input da linea di comando

        String utenteLoggato = null; // variabile che controlla se l'utente è loggato
        boolean esecuzioneProgramma = true;

        // Ciclo che gestisce l'esecuzione del programma
        while (esecuzioneProgramma) {
            // Se non loggato reindirizzo l'utente nel menu di autenticazione o
            // registrazione
            if (utenteLoggato == null) {

                String result = menuAutenticazione(usernames, passwords, scanner);

                // controllo uscita programma: se scelgo di uscire modifico la variabile
                // esecuzioneProgramma a false per permettere al ciclo while di terminare
                if (result != null && result.equals("EXIT")) {
                    esecuzioneProgramma = false;
                } else {
                    utenteLoggato = result;
                }
            }
            // se l'utente è loggato richiamo la funzione menuCalcolatrice() per
            // reindirizzare l'utente nel menu della calcolatrice
            else {

                String result = menuCalcolatrice(usernames, passwords, cronologia, scanner, utenteLoggato);
                if (result == null) {
                    utenteLoggato = null;
                    contatoreOperazioni = 0;
                } else {
                    utenteLoggato = result;
                }
            }
        }

        System.out.println("Programma terminato.");
    }

    // Menu di login per la registrazione, autenticazione e uscita
    static String menuAutenticazione(ArrayList<String> usernames, ArrayList<String> passwords, Scanner scanner) {

        System.out.println("\n======== MENU ========");
        System.out.println("1. Registrati");
        System.out.println("2. Login");
        System.out.println("3. Esci");
        System.out.print("Scelta: ");

        String scelta = scanner.nextLine();

        switch (scelta) {

            case "1":
                registrazione(usernames, passwords, scanner);
                return null;

            case "2":
                return login(usernames, passwords, scanner);

            case "3":
                return "EXIT"; // segnale di uscita

            default:
                System.out.println("Scelta non valida");
                return null;
        }
    }

    static void registrazione(
            ArrayList<String> usernames,
            ArrayList<String> passwords,
            Scanner scanner) {

        System.out.print("Username: ");
        String user = scanner.nextLine();

        for (String u : usernames) {
            if (u.equals(user)) {
                System.out.println("Username già esistente!");
                return;
            }
        }

        System.out.print("Password: ");
        String pass = scanner.nextLine();

        usernames.add(user);
        passwords.add(pass);

        System.out.println("Registrazione completata!");
    }

    static String login(
            ArrayList<String> usernames,
            ArrayList<String> passwords,
            Scanner scanner) {

        System.out.print("Username: ");
        String user = scanner.nextLine();

        System.out.print("Password: ");
        String pass = scanner.nextLine();

        for (int i = 0; i < usernames.size(); i++) {
            if (usernames.get(i).equals(user) && passwords.get(i).equals(pass)) {
                System.out.println("Login effettuato!");
                return user;
            }
        }

        System.out.println("Credenziali errate!");
        return null;
    }

    // ---------------- CALCOLATRICE portale dell'interfaccia quando l'utente riesce a loggarsi ----------------
    static String menuCalcolatrice(ArrayList<String> usernames,ArrayList<String> passwords,ArrayList<String> cronologia,Scanner scanner,String utenteLoggato) {

        if (contatoreOperazioni >= 4) {
            System.out.println("Hai fatto 4 operazioni. Devi riloggarti.");
            return null;
        }

        System.out.println("======== CALCOLATRICE ========");
        System.out.println("Operazioni: " + contatoreOperazioni + "/4");
        System.out.println("1. Somma");
        System.out.println("2. Sottrazione");
        System.out.println("3. Moltiplicazione");
        System.out.println("4. Divisione");
        System.out.println("5. Media");
        System.out.println("6. Storico");
        System.out.println("7. Logout");
        System.out.print("Scelta: ");

        String scelta = scanner.nextLine();

        switch (scelta) {

            case "1":
                contatoreOperazioni = somma(cronologia, scanner, contatoreOperazioni);
                break;

            case "2":
                contatoreOperazioni = sottrazione(cronologia, scanner, contatoreOperazioni);
                break;

            case "3":
                contatoreOperazioni = moltiplicazione(cronologia, scanner, contatoreOperazioni);
                break;

            case "4":
                contatoreOperazioni = divisione(cronologia, scanner, contatoreOperazioni);
                break;

            case "5":
                contatoreOperazioni = media(cronologia, scanner, contatoreOperazioni);
                break;

            case "6":
                mostraCronologia(cronologia);
                break;

            case "7":
                return null;
            default:
                System.out.println("Scelta non valida");
        }

        // se hai fatto 4 operazioni, ti butta fuori SUBITO dopo l'azione
        if (contatoreOperazioni >= 4) {
            System.out.println("\nHai raggiunto il limite di 4 operazioni. Verrai disconnesso.");
            return null;
        }

        return utenteLoggato;
    }

    // ---------------- INPUT ----------------

    static double[] inputNumbers(Scanner scanner) {

        System.out.print("Quanti numeri vuoi inserire? ");
        int n = Integer.parseInt(scanner.nextLine());

        double[] nums = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Numero " + (i + 1) + ": ");
            nums[i] = Double.parseDouble(scanner.nextLine());
        }

        return nums;
    }

    // ---------------- Funzioni con operazioni matematiche ----------------

    static int somma(ArrayList<String> cronologia, Scanner scanner, int contatoreOperazioni) {
        double[] nums = inputNumbers(scanner);

        double risultato = 0;
        String op = "Somma: ";

        for (double n : nums) {
            risultato += n;
            op += n + " ";
        }

        return salva(cronologia, op, risultato, contatoreOperazioni);
    }

    static int sottrazione(ArrayList<String> cronologia, Scanner scanner, int contatoreOperazioni) {
        double[] nums = inputNumbers(scanner);

        double risultato = nums[0];
        String op = "Sottrazione: " + nums[0] + " ";

        for (int i = 1; i < nums.length; i++) {
            risultato -= nums[i];
            op += "- " + nums[i] + " ";
        }

        return salva(cronologia, op, risultato, contatoreOperazioni);
    }

    static int moltiplicazione(ArrayList<String> cronologia, Scanner scanner, int contatoreOperazioni) {
        double[] nums = inputNumbers(scanner);

        double risultato = 1;
        String op = "Moltiplicazione: ";

        for (double n : nums) {
            risultato *= n;
            op += n + " ";
        }

        return salva(cronologia, op, risultato, contatoreOperazioni);
    }

    static int divisione(ArrayList<String> cronologia, Scanner scanner, int contatoreOperazioni) {
        double[] nums = inputNumbers(scanner);

        double risultato = nums[0];
        String op = "Divisione: " + nums[0] + " ";

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == 0) {
                System.out.println("Errore divisione per zero");
                return contatoreOperazioni;
            }

            risultato /= nums[i];
            op += "/ " + nums[i] + " ";
        }

        return salva(cronologia, op, risultato, contatoreOperazioni);
    }

    static int media(ArrayList<String> cronologia, Scanner scanner, int contatoreOperazioni) {
        double[] nums = inputNumbers(scanner);

        double somma = 0;
        for (double n : nums)
            somma += n;

        double risultato = somma / nums.length;

        String op = "Media: ";
        for (double n : nums)
            op += n + " ";

        return salva(cronologia, op, risultato, contatoreOperazioni);
    }

    // ---------------- Funzione contenente lo storico della cronologia ----------------

    static void mostraCronologia(ArrayList<String> cronologia) {

        System.out.println("\n======== STORICO ========");

        if (cronologia.isEmpty()) {
            System.out.println("Nessuna operazione.");
            return;
        }

        for (String h : cronologia) {
            System.out.println(h);
        }
    }

    static int salva(ArrayList<String> cronologia, String operazioni, double risultato, int contatoreOperazioni) {
        cronologia.add(operazioni + " = " + risultato);
        contatoreOperazioni++;
        System.out.println("Risultato: " + risultato);
        return contatoreOperazioni;
    }
}