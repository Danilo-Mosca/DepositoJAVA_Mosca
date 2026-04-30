/* ESERCIZIO:  Design pattern ES Observe 
Esercizio Medio – Sistema di Notifica Borsa
Obiettivo: Modellare un sistema in cui un'agenzia borsistica notifica più investitori su variazioni del valore azionario.

Requisiti:
    - Creare un'interfaccia Investitore con il metodo notifica(String azione, double valore).
    - Implementare la classe AgenziaBorsa con:
        - una lista di investitori registrati;
        - metodi aggiungiInvestitore, rimuoviInvestitore, notificaInvestitori;
        - un metodo aggiornaValoreAzione(String nome, double valore) che notifica gli investitori.
Implementare almeno due classi Investitore, es. InvestitorePrivato e InvestitoreBancario, che rispondono con messaggi personalizzati.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // Creo il Subject, l'osservato:
        AgenziaBorsa agenzia = new AgenziaBorsa();
        // Creo lo Scanner per l'input dell'utente:
        Scanner scanner = new Scanner(System.in);

        /* ----------- PROVE FUNZIONAMENTO SENZA MENU UTENTE ----------- */
        // Creo gli Observer:
        // Investitore privato1 = new InvestitorePrivato("Danilo");
        // Investitore banca1 = new InvestitoreBancario("Unicredit");

        // Registro gli Observer:
        // agenzia.aggiungiInvestitore(privato1);
        // agenzia.aggiungiInvestitore(banca1);

        // Cambio di stato:
        // agenzia.aggiornaValoreAzione("Nvidia", 320.50);
        // agenzia.aggiornaValoreAzione("Tesla", 14.20);
        /* ----------- FINE PROVE FUNZIONAMENTO SENZA MENU UTENTE ----------- */

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- MENU BORSA ---");
            System.out.println("1. Aggiungi un investitore privato");
            System.out.println("2. Aggiungi un investitore bancario");
            System.out.println("3. Rimuovi un investitore");
            System.out.println("4. Aggiorna valore azione");
            System.out.println("5. Esci");
            System.out.print("Scelta: ");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // pulizia buffer

            switch (scelta) {

                case 1:
                    System.out.print("Nome investitore: ");
                    String nome = scanner.nextLine();
                    Investitore privato = new InvestitorePrivato(nome);
                    agenzia.aggiungiInvestitore(privato);
                    System.out.println("Investitore privato aggiunto!");
                    break;

                case 2:
                    System.out.print("Nome banca: ");
                    String banca = scanner.nextLine();
                    Investitore bancario = new InvestitoreBancario(banca);
                    agenzia.aggiungiInvestitore(bancario);
                    System.out.println("Investitore bancario aggiunto!");
                    break;

                case 3:
                    System.out.print("Inserisci nome investitore da rimuovere: ");
                    String nomeDaRimuovere = scanner.nextLine();
                    agenzia.rimuoviInvestitore(nomeDaRimuovere);
                    break;

                case 4:
                    System.out.print("Nome azione: ");
                    String azione = scanner.nextLine();
                    System.out.print("Valore: ");
                    double valore = scanner.nextDouble();
                    agenzia.aggiornaValoreAzione(azione, valore);
                    break;

                case 5:
                    isRunning = false;
                    System.out.println("Uscita...");
                    break;

                default:
                    System.out.println("Scelta non valida!");
            }
        }

        scanner.close();
    }
}
