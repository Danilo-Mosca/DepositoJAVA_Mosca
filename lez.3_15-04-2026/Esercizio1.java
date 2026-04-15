/* ------------------------------------------------------------------
Es: while e do-while
Esercizio: Login con tentativi limitati e conferma finale
Scrivi un programma Java che:
1. Chieda all’utente di inserire una password.
2. L’utente ha massimo 3 tentativi per
inserirla correttamente.
3. La password corretta è "java123".

Usa un ciclo while per gestire i tentativi e un if per verificare se la
password è corretta.
Dopo
il login riuscito, usa un ciclo do-while per chiedere conferma
dell’accesso:
"Vuoi accedere al sistema? (s/n)"
Continua a chiedere finché non viene digitato s o n.
Inf
ine:
Se l’utente ha confermato con s, stampa "Accesso al sistema effettuato".
Se ha detto n, stampa "Accesso annullato".
Se i 3 tentativi vengono esauriti senza successo, stampa "Accesso bloccato". 
------------------------------------------------------------------ */

import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String passwordCorretta = "java123";
        String password = "";
        int tentativi = 0;
        boolean accessoConsentito = false;

        // WHILE: tentativi di login
        while (tentativi < 3 && !accessoConsentito) {
            System.out.println("Inserisci la password:");
            password = input.nextLine();

            if (password.equals(passwordCorretta)) {
                accessoConsentito = true;
            } else {
                tentativi++;
                System.out.println("Password errata. Tentativi rimasti: " + (3 - tentativi));
            }
        }

        // Se login fallito
        if (!accessoConsentito) {
            System.out.println("Accesso bloccato");
            return;
        }

        // DO-WHILE: conferma accesso
        String scelta;
        do {
            System.out.println("Vuoi accedere al sistema? (s/n)");
            scelta = input.nextLine();

        } while (!scelta.equals("s") && !scelta.equals("n"));

        // Risposta finale
        if (scelta.equals("s")) {
            System.out.println("Accesso al sistema effettuato");
        } else {
            System.out.println("Accesso annullato");
        }

        input.close();      // Chiudo lo Scanner "input" e libero le risorse
    }
}
