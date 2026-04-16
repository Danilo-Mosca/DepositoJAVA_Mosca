/* Esercizio 1: Funzione Base
Scrivi un metodo che calcola la somma di due numeri e restituisce il risultato.

Esercizio 2: Sfida sull'Overloading (??)
Crea due metodi multiply() sovraccaricati:
1.Uno che accetta due interi.
2.Uno che accetta tre numeri in virgola mobile (double).

Esercizio 3: Ricorsione - Somma dei Numeri Naturali
Scrivi una funzione ricorsiva che calcola la somma dei primi n numeri naturali.
Esempio:
sommaNaturali(5) → 5 + 4 + 3 + 2 + 1 = 15
Formula matematica:
S(n)=n+S(n−1)S(n) = n + S(n-1)S(n)=n+S(n−1)
con caso base:
S(1)=1S(1) = 1S(1)=1

Esercizio 4: Passaggio per Valore & Passaggio per Riferimento
Crea un metodo che modifica una variabile primitiva.
Crea un altro metodo che modifica un array.
stampa variabili prima e dopo */

import java.util.Scanner; // Importo la classe Scanner

public class Esercizio3Funzioni {
    public static void main(String[] args) {

        /* ------------ ESERCIZIO 1 Funzione Base ------------ */
        Scanner inputNumbers = new Scanner(System.in); // Crea un oggetto Scanner che permette di inserire numeri interi
        System.out.println("Inserisci il primo numero: ");
        int numero1 = inputNumbers.nextInt();
        System.out.println("Inserisci il secondo numero: ");
        int numero2 = inputNumbers.nextInt();
        System.out.println("La somma dei numeri è: " + somma(numero1, numero2));
        /* ------------ FINE ESERCIZIO 1 Funzione Base ------------ */



        /* ------------ ESERCIZIO 2 Sfida sull'Overloading ------------ */
        // Test metodo con interi
        int risultato1 = multiply(3, 4);
        System.out.println("Risultato interi: " + risultato1);

        // Test metodo con double
        double risultato2 = multiply(2.5, 3.0, 4.0);
        System.out.println("Risultato double: " + risultato2);
        /* ------------ FINE ESERCIZIO 2 Sfida sull'Overloading ------------ */



        /* ------------ ESERCIZIO 3 Ricorsione - Somma dei Numeri Naturali ------------ */
        System.out.println("Inserisci il numero per la somma dei numeri naturali: ");
        int sommaNumeriConRircorsione = inputNumbers.nextInt();
        int ricorsione = sommaNaturali(sommaNumeriConRircorsione);
        System.out.println("Somma dei primi 5 numeri naturali: " + ricorsione);
        /* ------------ FINE ESERCIZIO 3 Ricorsione - Somma dei Numeri Naturali ------------ */



        /* ------------ ESERCIZIO 4 Passaggio per Valore & Passaggio per Riferimento ------------ */
        // Modifica variabile primitiva:
        int numero = 10;
        System.out.println("Prima (primitiva): " + numero);
        modificaPrimitiva(numero);
        System.out.println("Dopo (primitiva): " + numero);      // Java utilizza sempre il passaggio per valore per i tipi primitivi (quindi il suo valore non cambia)

        // metodo che modifica un array
        int[] numeri = { 1, 2, 3 };

        System.out.println("Prima (array): " + numeri[0]);
        modificaArray(numeri);
        System.out.println("Dopo (array): " + numeri[0]);       // In Java gli oggetti e gli array sono passati per riferimento (quindi il suo valore cambia)
        /* ------------ FINE ESERCIZIO 4 Passaggio per Valore & Passaggio per Riferimento ------------ */
    }

    /* ------------ METODO ESERCIZIO 1 ------------ */
    // Metodo che calcola la somma di due numeri e restituisce il risultato:
    public static int somma(int a, int b){
        return a + b;
    }
    /* ------------ FINE METODO ESERCIZIO 1 ------------ */

    
    
    /* ------------ METODI ESERCIZIO 2 ------------ */
    // 1. Metodo con due interi
    public static int multiply(int a, int b) {
        return a * b;
    }

    // 2. Metodo con tre double
    public static double multiply(double a, double b, double c) {
        return a * b * c;
    }
    /* ------------ FINE METODI ESERCIZIO 2 ------------ */



    /* ------------ METODI ESERCIZIO 3 ------------ */
    // Metodo ricorsivo
    public static int sommaNaturali(int n) {
        // controllo se il numero inserito è 1, in questo caso ritorno direttamente il suo valore
        if (n == 1) {
            return 1;
        }
        // Eseguo la ricorsione per richiamare se stesso:
        return n + sommaNaturali(n - 1);
    }
    /* ------------ FINE METODI ESERCIZIO 3 ------------ */



    /* ------------ METODI ESERCIZIO 4 ------------ */
    // Metodo che prova a modificare una variabile primitiva
    public static int modificaPrimitiva(int x) {
        x = 100;
        System.out.println("Dentro il metodo (primitiva): " + x);
        return x;
    }

    // Metodo che modifica un array
    public static int[] modificaArray(int[] arr) {
        arr[0] = 999;
        System.out.println("Dentro il metodo (array): " + arr[0]);
        return arr;
    }
    /* ------------ FINE METODI ESERCIZIO 4 ------------ */
}