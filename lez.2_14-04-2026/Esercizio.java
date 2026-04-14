/* Scrivere un programma Java che chieda all'utente i seguenti dati:
   - La sua età (numero intero) 
   - Se possiede un biglietto valido (true o false)
   - Se è accompagnato da un adulto (true o false)
   - Se ha acquistato l'opzione "Salta la fila" (true o false)
*/

import java.util.Scanner; // Importo la classe Scanner

public class Esercizio {
    public static void main(String[] args) {
        Scanner inputInt = new Scanner(System.in); // Crea un oggetto Scanner
        Scanner inputString = new Scanner(System.in); // Crea un oggetto Scanner
        System.out.println("Inserisci la tua età:");
        int userEta = inputInt.nextInt(); // Leggo un user input: nextInt() legge e accetta valori di tipo int

        System.out.println("Possiedi un biglietto valido (rispondi con Si o No):");
        String userTicket = inputString.nextLine(); // Leggo un user input:nextLine() legge e accetta valori di tipo
                                                    // stringa o char

        System.out.println("Sei accompagnato da un adulto (rispondi con Si o No):");
        String userAdult = inputString.nextLine(); // Leggo un user input:nextLine() legge e accetta valori di tipo
                                                   // stringa o char

        System.out.println("Hai acquistato l'opzione Salta la Fila (rispondi con Si o No):");
        String skipLine = inputString.nextLine(); // Leggo un user input:nextLine() legge e accetta valori di tipo
                                                  // stringa o char

        // Stringa contentente l'output:
        // Mano a mano che procedo con l'esecuzione del codice aggiungo alla stringa "text" nuovi contenuti testuali
        String text = "Hai " + userEta + " anni.";

        // Condizione verifica inserimento ticket:
        if (userTicket.equals("si")) {
            text += " Il tuo ticket è valido.";
        } else {
            text += " Il tuo ticket non è valido.";
        }

        // Condizione verifica accompagnamento adulto:
        if (userAdult.equals("si")) {
            text += " Sei accompagnato da un adulto.";
        } else {
            text += " Non sei accompagnato da un adulto.";
        }

        // Condizione verifica inserimento "Salta la Fila":
        if (skipLine.equals("si")) {
            text += " Hai acquistato l'opzione Salta la Fila.";
        } else {
            text += " Non hai acquistato l'opzione Salta la Fila.";
        }

        System.out.println(text);
    }
}
