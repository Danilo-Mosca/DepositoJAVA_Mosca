/* Esercizio
Gestione voti con funzioni

Scrivi un programma che gestisce i voti di uno studente utilizzando le funzioni (metodi).
Il programma deve:
- Chiedere all’utente quanti voti vuole inserire
- Inserire i voti uno alla volta
- Mostrare un menu:
    1 - Calcola media
    2 - Mostra voto più alto
    3 - Mostra voto più basso
    4 - Verifica promozione
    5 - Esci

- Utilizzare uno switch
- Ogni operazione deve essere gestita da una funzione separata

Funzionalità richieste:
- calcolaMedia(somma, numeroVoti)
- trovaMax(max)
- trovaMin(min)
- verificaPromozione(media):
    - Se media ≥ 6 → "Promosso"
    - Altrimenti → "Bocciato" 
*/

import java.util.Scanner; // Importo la classe Scanner

public class Esercizio4GestioneVoti {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Crea un oggetto Scanner che permette di inserire quanti voti voglio aggiungere al programma
        Scanner inputScelte = new Scanner(System.in);
        System.out.println("Quanti voti dello studente vuoi inserire? ");
        int numVoti = input.nextInt();          // Leggo un user input: nextLine() legge e accetta valori di tipo interi
        double[] voti = new double[numVoti];    // Array che conterrà tutti i voti per quello studente
        double sommaVoti = 0;       // variabile contenente la somma totale dei voti inseriti per quell'utente

        // Ciclo "for" per l'inserimento dei voti dello studente:
        for (int i = 0; i < numVoti; i++) {
            System.out.println("Inserisci il voto numero " + (i + 1) + ":");
            voti[i] = input.nextDouble();       // Leggo un user input: nextLine() legge e accetta valori di tipo double (in virgola mobile)
            sommaVoti += voti[i];               // Incremento la variabile contenente la somma dei voti con il voto appena inserito
        }

        // Variabile di controllo:
        boolean menuFlag = true; // Inizializzo la variabile per il ciclo a true, in modo da tenere il menu sempre aperto per l'utente
        // Ciclo che rimane sul menù fino a quando l'utente non digita l'opzione "5" per l'uscita:
        do {
            System.out.println(
                    "Scegli una delle seguenti operazioni da far eseguire al programma (digitando 1, 2, 3, 4, 5): ");
            System.out.println("1. Calcola media");
            System.out.println("2. Mostra voto più alto");
            System.out.println("3. Mostra voto più basso");
            System.out.println("4. Verifica promozione");
            System.out.println("5. Esci");
            String scelte = inputScelte.nextLine();     // Leggo un user input: nextLine() legge e accetta valori di tipo String

            // Switch contenente le opzioni digitate dall'utente:
            switch (scelte) {
                case "1":
                    double media = calcolaMedia(sommaVoti, numVoti);
                    // "%.2f" significa che per quel valore double (la media) voglio visualizzare solo 2 cifre decimali dopo la virgola
                    System.out.println("La media dei voti è: " + String.format("%.2f", media));
                    // Oppure:
                    // System.out.printf("La media dei voti è: %.2f\n", media);
                    break;
                case "2":
                    double votoMax = trovaMax(voti[0], voti);
                    System.out.println("Il voto massimo è: " + votoMax);
                    break;
                case "3":
                    double votoMin = trovaMin(voti[0], voti);
                    System.out.println("Il voto minimo è: " + votoMin);
                    break;
                case "4":
                    // Prima richiamo la funzione che calcola la media:
                    double mediaPromozione = calcolaMedia(sommaVoti, numVoti);
                    // Successivamente richiamo la funzione verificaPromozione() che stampa a schermo se l'utente è stato bocciato o meno:
                    System.out.println("Lo studente è stato: " + verificaPromozione(mediaPromozione));
                    break;
                case "5":
                    menuFlag = false;
                    break;
                default:
                    System.out.println("Non hai inserito un'opzione valida, ritenta!");
                    break;
            }
        } while (menuFlag); // Il ciclo non terminerà finchè l'utente non digiterà "5"" dal menu così da terminare il programma

        input.close(); // Chiudo lo Scanner "input" e libero le risorse
        inputScelte.close(); // Chiudo lo Scanner "inputScelte" e libero le risorse
    }

    // Funzione che calcola la media:
    public static double calcolaMedia(double somma, int numeroVoti) {
        double media = somma / numeroVoti;
        return media;
    }

    // Funzione che calcola il voto più alto:
    public static double trovaMax(double max, double[] voti) {
        // assumiamo il primo valore dell array voti[0] come massimo iniziale
        for (int i = 1; i < voti.length; i++) {
            if (voti[i] > max) {
                max = voti[i];
            }
        }
        return max;
    }

    // Funzione che calcola il voto più basso:
    public static double trovaMin(double min, double[] voti) {
        // assumiamo il primo valore dell array voti[0] come minimo iniziale
        for (int i = 1; i < voti.length; i++) {
            if (voti[i] < min) {
                min = voti[i];
            }
        }
        return min;
    }

    // Funzione che verifica se lo studente è stato promosso o bocciato in base alla media dei voti:
    public static String verificaPromozione(double media) {
        if (media >= 6) {
            return "Promosso";
        } else {
            return "Bocciato";
        }
    }
}
