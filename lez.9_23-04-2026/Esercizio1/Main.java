/* Esercizio: Animali e Ereditarietà
Obiettivo:
Comprendere il concetto di ereditarietà in Java tramite la creazione di una classe base e due sottoclassi.

Traccia:
1. Crea una classe Animale con:
    - Attributi: nome (String), età (int)
    - Metodo: faiVerso() che stampa “Verso generico…”
2. Crea due sottoclassi che estendono Animale:
    - Cane, con override di faiVerso() che stampa “Bau!”
    - Gatto, con override di faiVerso() che stampa “Miao!”
3. Nel main:
    - Crea un array di Animale che contiene sia cani che gatti.
    - Stampa nome, età e verso di ciascun animale nel ciclo.
    - vai a creare una classe zoo con dentro almeno 3 tipi di animali divisi in liste diverse riempite dall’utente
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Array di Animale
        Animale[] animali = {
                new Cane("Dasty", 5),
                new Gatto("Rudi", 3),
                new Cane("Lenny", 10),
                new Gatto("Leo", 9)
        };

        System.out.println("--- VISUALIZZA ARRAY ANIMALI ---");
        // Foreach:
        for (Animale a : animali) {
            System.out.print("Nome animale: " + a.getNome() + " - Età: " + a.getEta() + " - verso: ");
            a.faiVerso();
        }

        // Animali inseriti dall'utente
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();

        int i = 0;
        System.out.println("Inserisci 3 animali!");
        while (i < 3) {
            System.out.println("Inserisci il tipo di animale (cane - gatto - uccello): ");
            String tipo = scanner.nextLine();

            System.out.println("Nome: ");
            String nome = scanner.nextLine();

            System.out.println("Età: ");
            int eta = scanner.nextInt();
            scanner.nextLine(); // pulizia buffer

            switch (tipo.toLowerCase()) {
                // Se inserisco uno dei tre animali (cane,gatto,uccello) incremento i++,
                // altrimenti richiedo all'utente di inserire un animale tra i 3:
                case "cane":
                    zoo.aggiungiCane(new Cane(nome, eta));
                    i++;
                    break;
                case "gatto":
                    zoo.aggiungiGatto(new Gatto(nome, eta));
                    i++;
                    break;
                case "uccello":
                    zoo.aggiungiUccello(new Uccello(nome, eta));
                    i++;
                    break;
                default:
                    System.out.println("Animale non valido! Reinserisci una tipologia tra: gane, catto o uccello");
            }
        }

        System.out.println("--- VISUALIZZA ZOO ---");
        zoo.stampaZoo();

        scanner.close();
    }
}
