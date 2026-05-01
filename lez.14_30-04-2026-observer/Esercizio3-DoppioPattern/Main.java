/* ESERCIZIO DOPPIO PATTERN
Progetta un'applicazione Java per la gestione di un sistema di notifiche di una piattaforma e-learning.

La piattaforma deve avere un unico gestore centrale delle notifiche, realizzato tramite il pattern Singleton. Il gestore deve permettere ai diversi utenti iscritti alla piattaforma di registrarsi e cancellarsi dalla ricezione delle notifiche.

Quando viene pubblicato un nuovo avviso, il gestore deve informare automaticamente tutti gli utenti registrati. La comunicazione tra il gestore delle notifhiche e gli utenti deve essere realizzata applicando il pattern Observer:

Ogni utente deve ricevere il messaggio dell'avviso e visualizzarlo con il proprio nome.

Realizzare le classi necessarie e un metodo main che dimostri il funzionamento del sistema registrando alcuni utenti, inviando almeno due notifiche e rimuovendo almeno un utente prima dell'invio di una nuova notificha. 
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Creo il Subject osservabile S_GestoreNotifice con pattern Singleton:
        S_GestoreNotifiche gestoreNotifiche = S_GestoreNotifiche.getInstance();
        // Creo lo Scanner per l'input dell'utente:
        Scanner scanner = new Scanner(System.in);

        // /* ----------- TEST SENZA MENU UTENTE ----------- */
        // Creazione degli utenti:
        // Utente utente1 = new Utente("Danilo","Mosca");
        // Utente utente2 = new Utente("Paolo", "Rossi");
        // Utente utente3 = new Utente("Giovanni", "Verdi");

        // Iscrivo gli Utenti (osservatori) al Subject così da ricevere le notifiche:
        // gestoreNotifiche.registraUtente(utente1);
        // gestoreNotifiche.registraUtente(utente2);
        // gestoreNotifiche.registraUtente(utente3);

        // gestoreNotifiche.pubblicaAvviso("Prima notifica: Benvenuto! grazie per
        // esserti iscritto");
        // System.out.println("==============================");
        // gestoreNotifiche.pubblicaAvviso("Seconda notifica: questa è una seconda");

        // Rimozione di un utente:
        // gestoreNotifiche.rimuoviUtente(utente3);
        // System.out.println("==============================");
        // gestoreNotifiche.pubblicaAvviso("Un utente è stato rimosso!");
        /* ----------- FINE TEST SENZA MENU UTENTE ----------- */

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- MENU PIATTAFORMA E-LEARNING ---");
            System.out.println("1. Registra un utente");
            System.out.println("2. Cancella un utente");
            System.out.println("3. Invia una notifica");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");

            String scelta = scanner.nextLine();

            switch (scelta) {
                case "1":
                    System.out.print("Nome nuovo utente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Cognome nuovo utente: ");
                    String cognome = scanner.nextLine();
                    Utente nuovo = new Utente(nome, cognome);
                    gestoreNotifiche.registraUtente(nuovo);
                    System.out.println("Utente registrato!");
                    break;

                case "2":
                    System.out.print("Nome dell'utente da rimuovere: ");
                    String nomeRegistrato = scanner.nextLine();
                    System.out.print("Cognome dell'utente da rimuovere: ");
                    String cognomeRegistrato = scanner.nextLine();
                    gestoreNotifiche.rimuoviUtente(new Utente(nomeRegistrato, cognomeRegistrato));
                    break;

                case "3":
                    System.out.print("Scrivi in messaggio da inviare: ");
                    String messaggio = scanner.nextLine();
                    gestoreNotifiche.pubblicaAvviso(messaggio);
                    break;

                case "4":
                    isRunning = false;
                    System.out.println("Uscita dal programma!");
                    break;

                default:
                    System.out.println("Scelta inserita non valida");
                    break;
            }
        }
        scanner.close();
    }
}