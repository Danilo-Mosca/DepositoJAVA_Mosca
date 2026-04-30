/* ESERCIZIO DOPPIO PATTERN
Progetta un'applicazione Java per la gestione di un sistema di notifiche di una piattaforma e-learning.

La piattaforma deve avere un unico gestore centrale delle notifiche, realizzato tramite il pattern Singleton. Il gestore deve permettere ai diversi utenti iscritti alla piattaforma di registrarsi e cancellarsi dalla ricezione delle notifiche.

Quando viene pubblicato un nuovo avviso, il gestore deve informare automaticamente tutti gli utenti registrati. La comunicazione tra il gestore delle notifhiche e gli utenti deve essere realizzata applicando il pattern Observer:

Ogni utente deve ricevere il messaggio dell'avviso e visualizzarlo con il proprio nome.

Realizzare le classi necessarie e un metodo main che dimostri il funzionamento del sistema registrando alcuni utenti, inviando almeno due notifiche e rimuovendo almeno un utente prima dell'invio di una nuova notificha. 
*/

public class Main {

    public static void main(String[] args) {

        // Creo il Subject osservabile S_GestoreNotifice con pattern Singleton:
        S_GestoreNotifice gestoreNotifice = S_GestoreNotifice.getInstance();

        // Creazione degli utenti:
        Utente utente1 = new Utente("Danilo","Mosca");
        Utente utente2 = new Utente("Paolo", "Rossi");
        Utente utente3 = new Utente("Giovanni", "Verdi");

        // Iscrivo gli Utenti (osservatori) al Subject così da ricevere le notifiche:
        gestoreNotifice.registraUtente(utente1);
        gestoreNotifice.registraUtente(utente2);
        gestoreNotifice.registraUtente(utente3);

        gestoreNotifice.pubblicaAvviso("Prima notifica: Benvenuto! grazie per esserti iscritto");
        System.out.println("==============================");
        gestoreNotifice.pubblicaAvviso("Seconda notifica: questa è una seconda");

        // Rimozione di un utente:
        gestoreNotifice.rimuoviUtente(utente3);
        System.out.println("==============================");
        gestoreNotifice.pubblicaAvviso("Un utente è stato rimosso!");
    }
}