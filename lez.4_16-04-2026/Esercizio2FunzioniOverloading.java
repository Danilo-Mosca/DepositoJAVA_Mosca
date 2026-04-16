/* Esercizio
Creare un metodo che accetti un numero intero e restituisca il suo fattoriale.
Se il parametro passato è una stringa scrive “Inserisci un numero valido”
(svolgere l’esercizio con l’overloading) */

import java.util.Scanner; // Importo la classe Scanner

public class Esercizio2FunzioniOverloading {
    
    public static void main(String[] args) {
        Scanner inputNumbers = new Scanner(System.in); // Crea un oggetto Scanner che permette di inserire numeri interi
        System.out.println("Inserisci un numero valido");
        int numeri = inputNumbers.nextInt();
        System.out.println(fattoriale(numeri));

        inputNumbers.close();
    }

    // Metodo per il calcolo del fattoriale
    public static long fattoriale(int n) {
        if (n < 0) {
            System.out.println("Il numero deve essere positivo");
            return -1;  // siccome la funzione deve restituire un valore, gli faccio ritornare un numero negativo perchè il fattoriale di un numero non può mai essere negativo, quindi -1 è un modo semplice per dire: “qualcosa è andato storto”
        }

        long risultato = 1;

        for (int i = 1; i <= n; i++) {
            risultato *= i;
        }
        return risultato;
    }
}
