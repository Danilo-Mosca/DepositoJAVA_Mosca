/* ESERCIZIO: Gestione di una Piattaforma di Notifiche Personalizzabili
Descrizione generale:
In un gruppo di lavoro, progettate un’applicazione Java che simuli una piattaforma in cui utenti ricevono notifiche da una sorgente centrale, e possono personalizzarne il contenuto o la forma. L’applicazione deve integrare tre design pattern obbligatori: Singleton, Decorator, Observer.

Obiettivo didattico:
- Comprendere e applicare design pattern reali in un sistema coeso
- Lavorare in gruppo su componenti modulari
- Usare Java in modo avanzato con progettazione orientata agli oggetti

Requisiti obbligatori:
    1. Pattern Singleton – Gestore Notifiche Unico
Create una classe NotificationManager che:
- È una Singleton
- Rappresenta la sorgente centrale da cui partono le notifiche
- Contiene un metodo inviaNotifica(String messaggio)

    2. Pattern Observer – Utenti che ricevono notifiche
Ogni utente è un oggetto che:
- Implementa un’interfaccia Observer
- Si registra a NotificationManager
- Riceve il messaggio e lo stampa sul terminale
- Deve poter essere aggiunto e rimosso dinamicamente

    3. Pattern Decorator – Person alizzazione delle notifiche
Create decoratori per modificare il messaggio prima della stampa da parte dell’utente:
- Aggiunta di timestamp
- Conversione in maiuscolo/minuscolo
- Aggiunta di emoji o prefissi

Ogni utente può essere decorato in modo diverso.

Esempio funzionale atteso:
- Il NotificationManager invia “Sistema in manutenzione”
- L’utente 1 stampa: [2025-07-09 10:30] SISTEMA IN MANUTENZIONE
- L’utente 2 stampa: Notifica: Sistema in manutenzione
- L’utente 3 non è più iscritto e non riceve nulla
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Creo l'unica istanza istanza possibile (perché Singleton) del Subject
        // (osservato): S_NotificationManager
        S_NotificationManager gestoreNotifiche = S_NotificationManager.getInstance();

        /* ---------- TEST FUNZIONAMENTO ---------- */
        /* ======================================================================================================== */
        // Mi creo un primo messaggio base
        // Message messaggio1 = new MessageBaseDecorator(); // Messaggio base
        // che a sua volta avrà un messaggio con data, in maiuscolo e con le emoji
        // (quindi tutti e tre i decoratori):
        // messaggio1 = new TimestampDecorator(messaggio1); // Messaggio base +
        // timestamp
        // messaggio1 = new UppercaseDecorator(messaggio1); // Messaggio base +
        // timestamp + MIAUSCOLO
        // messaggio1 = new EmojiDecorator(messaggio1); // Messaggio base + timestamp +
        // MIAUSCOLO + emoji
        // Mi creo un primo utente che avrà associato l'oggetto messaggio1 con tutti i
        // suoi decoratori
        // Utente utente1 = new Utente("Danilo", "Mosca", messaggio1);

        // Mi creo un secondo messaggio e un secondo utente che avrà il messaggio con il
        // timestamp:
        // Message messaggio2 = new MessageBaseDecorator(); // Messaggio base
        // messaggio2 = new TimestampDecorator(messaggio2); // Messaggio base +
        // timestamp
        // Mi creo un secondo utente che avrà associato l'oggetto messaggio2 con tutti
        // il decoratore per il timestamp
        // Utente utente2 = new Utente("Luca", "Bianchi", messaggio2);

        // Mi creo un terzo messaggio che avrà soltanto il messaggio base (cioè senza né
        // timestamp, né maiuscolo, ne emoji):
        // Message messaggio3 = new MessageBaseDecorator(); // Messaggio base
        // Mi creo un terzo utente che avrà associato l'oggetto messaggio3 con i
        // relativi decoratori se presenti
        // Utente utente3 = new Utente("Anna", "Verdi", messaggio3);

        // Registro gli utenti in modo che possano ricevere le notifiche dal sistema
        // gestoreNotifiche.addObserver(utente1);
        // gestoreNotifiche.addObserver(utente2);
        // gestoreNotifiche.addObserver(utente3);

        // Invio una notifiche a tutti e tre gli utenti registrati (ognuno le vedrà in
        // base al decorator associato o meno)
        // gestoreNotifiche.inviaNotifica("Ciao a tutti!");

        // Rimuovo un utente
        // gestoreNotifiche.removeObserver(utente3);
        // Invio nuovamente le notifiche per vedere come l'utente appena cancellato non
        // riceverà nessuna modifica
        // gestoreNotifiche.inviaNotifica("L'utente 3 si è disiscritto");
        /* ======================================================================================================== */
        /* ---------- FINE TEST FUNZIONAMENTO ---------- */

        // Creo lo Scanner per l'input dell'utente
        Scanner input = new Scanner(System.in);
        boolean isTrue = true; // Variabile di controllo del ciclo
        List<Utente> utenti = new ArrayList<>(); // Aggiungo una lista degli utenti iscritti

        while (isTrue) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Aggiungi un utente");
            System.out.println("2. Rimuovi un utente");
            System.out.println("3. Invia un messaggio");
            System.out.println("4. Mostra tutti gli utenti");
            System.out.println("5. Esci");
            System.out.print("Scelta: ");

            String scelta = input.nextLine();

            switch (scelta) {
                case "1":
                    /* INSERIMENTO UTENTE */
                    System.out.print("Inserisci il nome del nuovo utente: ");
                    String nome = input.nextLine();
                    System.out.print("Inserisci il cognome del nuovo utente: ");
                    String cognome = input.nextLine();
                    // Creo l'instanza del messaggio base
                    Message messaggio = new MessageBaseDecorator();
                    // Successivamente chiedo all'utente di scegliere un tipo di decoratore per la
                    // visualizzazione dei proprio messaggi richiamando una funzione statica che
                    // controlla l'inserimento corretto del decoratore da parte dell'utente
                    messaggio = sceltaDecoratore(input, messaggio);
                    // Una volta scelto il tipo di decoratore, mi creo una nuova istanza di Utente
                    // che avrà nome, cognome e tipo di Decoratore scelto
                    Utente utente = new Utente(nome, cognome, messaggio);
                    // Aggiungo l'utente alla lista del Subject (osservante)
                    gestoreNotifiche.addObserver(utente);
                    // E lo aggiungo anche all'arraylist della classe
                    utenti.add(utente);
                    break;

                case "2":
                    /* CANCELLAZIONE UTENTE */
                    System.out.print("Nome dell'utente da rimuovere: ");
                    String nomeRegistrato = input.nextLine();
                    System.out.print("Cognome dell'utente da rimuovere: ");
                    String cognomeRegistrato = input.nextLine();

                    // Prima controllo che la lista degli utenti registrati non sia vuota
                    if (utenti.isEmpty()) {
                        System.out.println("Non è presente nessun utente registrato");
                    } else {
                        Utente utenteCancellare = null;
                        for (Utente utenteSingolo : utenti) {
                            if (utenteSingolo.getNome().equalsIgnoreCase(nomeRegistrato) && utenteSingolo.getCognome().equalsIgnoreCase(cognomeRegistrato)) {
                                utenteCancellare = utenteSingolo;
                                gestoreNotifiche.removeObserver(utenteCancellare);
                                System.out.println("Utente rimosso");
                                break;
                            }
                        }
                        if (utenteCancellare != null) {
                            utenti.remove(utenteCancellare);
                        }
                        else {
                            System.out.println("Utente non trovato");
                        }
                    }
                    break;

                case "3":
                    /* INVIO NOTIFICA DA PARTE DEL SISTEMA */
                    System.out.print("Inserisci il messaggio da inviare a tutti gli utenti registrati: ");
                    String messaggioInput = input.nextLine();
                    gestoreNotifiche.inviaNotifica(messaggioInput);
                    break;

                case "4":
                    /* MOSTRA TUTTI GLI UTENTI REGISTRATI */
                    // Prima controllo che la lista degli utenti registrati non sia vuota
                    if (utenti.isEmpty()) {
                        System.out.println("Non è presente nessun utente registrato");
                    } else {
                        System.out.println("======== Utenti registrati ========");
                        for (int i = 0; i < utenti.size(); i++) {
                            System.out.println(
                                    "Nome: " + utenti.get(i).getNome() + " - Cognome: " + utenti.get(i).getCognome());
                        }
                    }
                    break;

                case "5":
                    /* USCITA DAL PROGRAMMA */
                    isTrue = false;
                    System.out.println("Uscita dal programma!");
                    break;

                default:
                    System.out.println("Scelta inserita non valida");
                    break;
            }
        }
        input.close();
    }

    // Metodo statico che assegna al messaggio il decoratore scelto da ogni
    // specifico utente
    static Message sceltaDecoratore(Scanner input, Message sceltaDecoratore) {
        boolean isDecorator = true; // Variabile di controllo del ciclo per la scelta del decoratore

        // Chiedo all'utente di scegliere un tipo di decoratore per la visualizzazione
        // dei proprio messaggi
        System.out
                .println("Vuoi aggiungere un decoratore per i messaggi che ricevi? Digita una delle seguenti opzioni");
        System.out.println("1. Nessuno");
        System.out.println("2. Timestamp");
        System.out.println("3. Uppercase");
        System.out.println("4. Emoji");
        System.out.print("Scelta: ");
        // Ciclo che controlla l'inserimento corretto del decoratore da parte
        // dell'utente
        while (isDecorator) {
            String decorator = input.nextLine();

            switch (decorator) {
                case "1":
                    // Ritorno così com'è il messaggio (il messaggio di base)
                    sceltaDecoratore = new MessageBaseDecorator();
                    isDecorator = false;
                    break;

                case "2":
                    sceltaDecoratore = new TimestampDecorator(sceltaDecoratore);
                    isDecorator = false;
                    break;

                case "3":
                    sceltaDecoratore = new UppercaseDecorator(sceltaDecoratore);
                    isDecorator = false;
                    break;

                case "4":
                    sceltaDecoratore = new EmojiDecorator(sceltaDecoratore);
                    isDecorator = false;
                    break;

                default:
                    System.out.println("Scelta inserita non valida");
                    break;
            }
        }
        return sceltaDecoratore;
    }
}