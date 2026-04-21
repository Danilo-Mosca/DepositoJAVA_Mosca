/* TESTO ESERCIZIO
Classi e oggetti in Java

Definisci una classe Libro con attributi: titolo, autore, prezzo, codice_numerico_autoincrementante.
Crea due oggetti libro e stampa i loro dettagli.
*/

public class Libro {
    // Attributi:
    String titolo;
    String autore;
    double prezzo;
    
    static int codice_numerico_autoincrementante = 1000;

    // Metodi:
    public void mostraInfo() {
        System.out.println("Hai scelto il libro: " + titolo + " dell'autore: " + autore + ". Costo di listino: " + prezzo + " € \n Codice numerico autoincrementante: " + codice_numerico_autoincrementante);
    }

    // Metodo statico:
    public static void incrementCodiceNumerico(){
        codice_numerico_autoincrementante++;
    }
}
