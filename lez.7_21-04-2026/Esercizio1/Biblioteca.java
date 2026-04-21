import java.util.ArrayList;

public class Biblioteca {
    public static void main(String[] args) {
        Libro libro1 = new Libro();

        libro1.titolo = "Harry Potter e la pietra filosofale";
        libro1.autore = "J.K. Rowling";
        libro1.prezzo = 15.00;
        // Libro.codice_numerico_autoincrementante++;   //Incremento direttamente la variabile statica
        // Oppure richiamando ad esempio un metodo normale o come in questo caso un metodo statico:
        Libro.incrementCodiceNumerico();       // Incremento la variabile statica attraverso il metodo

        Libro libro2 = new Libro();

        libro2.titolo = "Il Signore degli Anelli";
        libro2.autore = "J.R.R. Tolkien";
        libro2.prezzo = 30.00;
        Libro.codice_numerico_autoincrementante++;

        System.out.println("I libri che hai selezionato sono i seguenti:");
        libro1.mostraInfo();
        libro2.mostraInfo();


        // Esempio con ArrayList:
        ArrayList<Libro> libri = new ArrayList<>();
        libri.add(libro1);
        libri.add(libro2);

        // For-each per visualizzare i libri:
        for(Libro listaLibri : libri){
            listaLibri.mostraInfo();
            // Libro.codice_numerico_autoincrementante++;      //Incremento diretto della variabile statica
            // Oppure incremento della variabile statica tramite metodo anch'esso statico:
            Libro.incrementCodiceNumerico();
        }
    }
}
