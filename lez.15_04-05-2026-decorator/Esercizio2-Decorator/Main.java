/* ESERCIZIO: Esercizio Medio:
Obiettivo: simulare un sistema di ordini di hamburger usando il pattern Decorator.
Richiesta:
    - Crea un'interfaccia Hamburger con i metodi String getDescrizione() e double getPrezzo().
    - Implementa la classe concreta BaseBurger.
    - Crea almeno due decoratori concreti: FormaggioDecorator (+0.50€) e BaconDecorator (+0.80€).
    - Permetti la combinazione di più decoratori per un singolo ordine.
    - Scrivi un Main che costruisce un hamburger con entrambi gli extra e ne stampa descrizione e prezzo finale.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Creo lo Scanner per l'input dell'utente:
        Scanner input = new Scanner(System.in);

        // Creo un'instanza della classe BaseBurger che implementa l'interfaccia
        // Hamburger
        Hamburger hamburger = new BaseBurger();

        boolean isTrue = true; // Variabile di controllo ciclo while
        while (isTrue) {
            System.out.println("-------- MENU HAMBURGER --------");
            System.out.println("1. Aggiungi il formaggio (+0.50€)");
            System.out.println("2. Aggiungi il bacon (+0.80€)");
            System.out.println("3. Mostra ordine e totale importo");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");

            String scelta = input.nextLine();

            switch (scelta) {
                case "1":
                    hamburger = new FormaggioDecorator(hamburger);
                    System.out.println("Ho aggiunto il formaggio!");
                    break;

                case "2":
                    hamburger = new BaconDecorator(hamburger);
                    System.out.println("Ho aggiunto il bacon!");
                    break;

                case "3":
                    System.out.println("\n--- ORDINE ---");
                    System.out.println("Descrizione: " + hamburger.getDescrizione());
                    System.out.println("Prezzo finale: " + hamburger.getPrezzo() + "€");
                    break;

                case "4":
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
}