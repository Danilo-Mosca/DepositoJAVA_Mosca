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

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Creo l'unica istanza istanza possibile (perché Singleton) del Subject
        // (osservato): S_NotificationManager
        S_NotificationManager gestoreNotifiche = S_NotificationManager.getInstance();
        // Creo lo Scanner per l'input dell'utente
        Scanner input = new Scanner(System.in);

        boolean isTrue = true; // Variabile di controllo del ciclo
        
        /* ---------- TEST FUNZIONAMENTO ---------- */
        // Mi creo un primo messaggio base
        Message messaggio1 = new MessageBaseDecorator();            // Messaggio base
        // che a sua volta avrà un messaggio con data, in maiuscolo e con le emoji (quindi tutti e tre i decoratori):
        messaggio1 = new TimestampDecorator(messaggio1);            // Messaggio base + timestamp
        messaggio1 = new UppercaseDecorator(messaggio1);            // Messaggio base + timestamp + MIAUSCOLO
        messaggio1 = new EmojiDecorator(messaggio1);                // Messaggio base + timestamp + MIAUSCOLO + emoji
        // Mi creo un primo utente che avrà associato l'oggetto messaggio1 con tutti i suoi decoratori
        Utente utente1 = new Utente("Danilo", "Mosca", messaggio1);

        // Mi creo un secondo messaggio e un secondo utente che avrà il messaggio con il timestamp:
        Message messaggio2 = new MessageBaseDecorator();            // Messaggio base
        messaggio2 = new TimestampDecorator(messaggio2);            // Messaggio base + timestamp
        // Mi creo un secondo utente che avrà associato l'oggetto messaggio2 con tutti il decoratore per il timestamp
        Utente utente2 = new Utente("Luca", "Bianchi", messaggio2);

        // Mi creo un terzo messaggio che avrà soltanto il messaggio base (cioè senza né timestamp, né maiuscolo, ne emoji):
        Message messaggio3 = new MessageBaseDecorator();          // Messaggio base
        // Mi creo un terzo utente che avrà associato l'oggetto messaggio3 con i relativi decoratori se presenti
        Utente utente3 = new Utente("Anna", "Verdi", messaggio3);


        // Registro gli utenti in modo che possano ricevere le notifiche dal sistema
        gestoreNotifiche.addObserver(utente1);
        gestoreNotifiche.addObserver(utente2);
        gestoreNotifiche.addObserver(utente3);

        // Invio una notifiche a tutti e tre gli utenti registrati (ognuno le vedrà in base al decorator associato o meno)
        gestoreNotifiche.inviaNotifica("Ciao a tutti!");

        // Rimuovo un utente
        gestoreNotifiche.removeObserver(utente3);
        // Invio nuovamente le notifiche per vedere come l'utente appena cancellato non riceverà nessuna modifica
        gestoreNotifiche.inviaNotifica("L'utente 3 si è disiscritto");
        /* ---------- FINE TEST FUNZIONAMENTO ---------- */
    }
}