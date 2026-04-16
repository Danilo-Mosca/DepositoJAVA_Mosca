/* ArrayList
Scrivi un sistema Java che:
Crei una ArrayList di stringhe per memorizzare nomi di studenti.
L'utente può aggiungere nomi finché non scrive "fine".
Il programma deve stampare tutti i nomi in ordine alfabetico.
Il programma deve dire quanti studenti sono stati inseriti.
Il programma deve permettere di eliminare degli studenti indicati dall’utente */

import java.util.ArrayList; // importo l'ArrayList per poterlo utilizzare nella classe
import java.util.Collections;
import java.util.Scanner; // Importo la classe Scanner

public class Esercizio1ArrayList {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Crea un oggetto Scanner che permette di inserire gli utenti
        boolean userInput = true; // variabile di controllo inserimento utenti
        ArrayList<String> nomiStudenti = new ArrayList<>();
        // Ciclo while che viene utilizzato per inserire gli studenti finché l'utente
        // non scrive "fine"
        while (userInput) {
            System.out.println("Inserisci i nomi degli studenti (digita \'fine\' per terminare l'inserimento): ");
            String nomi = input.nextLine();
            // Controllo se l'utente ha inserito la stringa "fine" per terminare
            // l'inserimento degli studenti:
            if (nomi.equalsIgnoreCase("fine")) {
                // "equalsIgnoreCase" a differenza di "equals" controlla non è case sensitive,
                // quindi maiuscole e minuscole digitate nel testo non vengono considerate
                // diverse
                userInput = false;
            } else {
                nomiStudenti.add(nomi);
            }
        }

        System.out.println("Scegli una delle seguenti operazioni da far eseguire al programma (digitando 1, 2, 3): ");
        System.out.println("1. Il programma deve stampare tutti i nomi in ordine alfabetico");
        System.out.println("2. Il programma deve dire quanti studenti sono stati inseriti.");
        System.out.println("3. Il programma deve permettere di eliminare degli studenti indicati dall’utente");
        String scelte = input.nextLine();

        switch (scelte) {
            case "1":
                Collections.sort(nomiStudenti); // Ordino gli studenti alfabeticamente
                System.out.println("Lista degli studenti ordinata alfabeticamente: " + nomiStudenti);
                break;
            case "2":
                int numeroTotaleStudenti = nomiStudenti.size();
                System.out.println("Lista degli studenti ordinata alfabeticamente: " + nomiStudenti);
                break;
            case "3":
                boolean studentiDelete = true;
                while (studentiDelete) {
                    System.out.println("Digita il nome degli studenti da eliminare (digita fine per terminare): ");
                    String nomiDaEliminare = input.nextLine();
                    if (nomiDaEliminare.equalsIgnoreCase("fine")) {
                        // "equalsIgnoreCase" a differenza di "equals" controlla non è case sensitive, quindi maiuscole e minuscole digitate nel testo non vengono considerate diverse
                        studentiDelete = false;
                    } else if (nomiStudenti.contains(nomiDaEliminare)) {
                        nomiStudenti.remove(nomiDaEliminare);
                    } else {
                        System.out.println(
                                "Non è possibile eliminare lo studente " + nomiDaEliminare + " perchè non esiste!");
                    }
                }
                System.out.println("Lista degli studenti ordinata alfabeticamente: " + nomiStudenti);
                break;
            default:
                break;
        }
        
        input.close();      // Chiudo lo Scanner "inputNumbers" e libero le risorse
    }
}
