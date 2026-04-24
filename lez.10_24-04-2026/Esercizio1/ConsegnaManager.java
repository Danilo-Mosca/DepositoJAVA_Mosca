/* ESERCIZIO
Obiettivo:
Comprendere la differenza tra classe astratta e interfaccia, il loro utilizzo e come si applica l'astrazione per modellare comportamenti comuni e specializzati tra classi diverse.
Traccia:
Progetta un sistema Java che simuli un servizio di consegna (delivery) in cui esistono diversi tipi di mezzi che effettuano le consegne in modo differente.
1. Classe Astratta VeicoloConsegna
    - Attributi:
        - targa (String)
        - caricoMassimo (float)
    - Metodo astratto:
        - consegnaPacco(String destinazione)
    - Metodi concreti:
        - stampaInfo(): stampa i dati del veicolo

2. Interfaccia Tracciabile
    - Metodo:
        - tracciaConsegna(String codiceTracking): simula la tracciabilità della spedizione

3. Classi Concrete
Crea almeno due classi che estendono VeicoloConsegna e implementano Tracciabile:
    - Furgone: stampa che sta consegnando via strada con targa e destinazione
    - Drone: stampa che sta volando verso la destinazione e fornisce un tracking automatico

4. Classe Principale ConsegnaManager
    - Crea una lista o array di oggetti VeicoloConsegna
    - Permetti all’utente di aggiungere un veicolo (furgone o drone), impostare i dati, e chiamare i metodi consegnaPacco() e tracciaConsegna()
    - Dimostra il concetto di polimorfismo e astrazione (lavorando con riferimenti astratti)

Requisiti Tecnici:
    - Usare almeno una classe astratta con metodo astratto
    - Usare un’interfaccia implementata da più classi

Estensione Facoltativa:
Aggiungi un controllo del carico: se la consegna supera il caricoMassimo, il metodo consegnaPacco() stampa un errore.
*/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ConsegnaManager {

    public static void main(String[] args) {

        ArrayList<VeicoloConsegna> listaVeicoli = new ArrayList<>();
        ArrayList<String> listaDestinazioni = new ArrayList<>();
        ArrayList<Float> caricoMassimoPacco = new ArrayList<>(); // Lista contenente il peso dei singoli pacchi

        Scanner inputUtente = new Scanner(System.in);
        boolean flagWhile = true;

        while (flagWhile) {
            System.out.println("Crea un veicolo:");
            System.out.println("Scrivi 1 - per inserire un Furgone");
            System.out.println("Scrivi 2 - per inserire un Drone");
            System.out.println("Scrivi 3 - per uscire dal programma");

            String scelta = inputUtente.nextLine();
            String targa;
            Float caricoMassimoAppoggio;
            switch (scelta) {
                case "1":
                    System.out.print("Inserisci targa: ");
                    targa = inputUtente.nextLine();

                    System.out.print("Inserisci il carico massimo per i Furgoni: ");
                    caricoMassimoAppoggio = inputUtente.nextFloat();
                    inputUtente.nextLine(); // pulizia buffer

                    VeicoloConsegna veicoloFurgone = new Furgone(targa, caricoMassimoAppoggio);
                    listaVeicoli.add(veicoloFurgone);

                    System.out.print("Inserisci la destinazione (CAP - VIA - CITTA'): ");
                    listaDestinazioni.add(inputUtente.nextLine());

                    System.out.print("Inserisci il peso del pacco: ");
                    caricoMassimoPacco.add(inputUtente.nextFloat());
                    inputUtente.nextLine(); // pulisco il buffer
                    break;

                case "2":
                    System.out.print("Inserisci targa: ");
                    targa = inputUtente.nextLine();

                    System.out.print("Inserisci il carico massimo per i Droni: ");
                    caricoMassimoAppoggio = inputUtente.nextFloat();
                    inputUtente.nextLine(); // pulizia buffer

                    VeicoloConsegna veicoloDrone = new Drone(targa, caricoMassimoAppoggio);
                    listaVeicoli.add(veicoloDrone);

                    System.out.println("Inserisci la destinazione (CAP - VIA - CITTA'): ");
                    listaDestinazioni.add(inputUtente.nextLine());

                    System.out.print("Inserisci il peso del pacco: ");
                    caricoMassimoPacco.add(inputUtente.nextFloat());
                    inputUtente.nextLine(); // pulisco il buffer
                    break;
                case "3":
                    flagWhile = false; // Imposto la variabile booleana flagWhile a false per uscire dal ciclo while
                    break;
                default:
                    System.out.println("Hai inserito una tipologia non valida!");
                    break;
            }
        }

        // Richiamo i metodi consegnaPacco() e tracciaConsegna():
        System.out.println("======== LISTA DELLE CONSEGNE ========");
        for (int i = 0; i < listaVeicoli.size(); i++) {

            VeicoloConsegna veicolo = listaVeicoli.get(i);      //prendo il singolo veicolo dall'ArrayList
            String destinazione = listaDestinazioni.get(i);     //prendo la singola destinazione dall'ArrayList
            float peso = caricoMassimoPacco.get(i);             //prendo il peso corrente del pacco[i] in consegna

            System.out.println("\n--- CONSEGNA " + (i + 1) + " ---");

            // POLIMORFISMO: chiamata al metodo astratto:
            // se il "veicolo" corrente della classe astratta "VeicoloConsegna" è "Furgone" allora esegue il metodo Furgone.consegnaPacco()
            // mentre se il "veicolo" corrente della classe astratta "VeicoloConsegna" è "Drone" allora esegue il metodo Drone.consegnaPacco()
            veicolo.consegnaPacco(destinazione, peso);

            // Interfaccia
            // Controllo se veicolo implementa l’interfaccia Tracciabile. Controllo scontato perchè in questo caso la implementa sempre:
            // "veicolo" è un "VeicoloConsegn", ma può essere sia "Furgone" che "Drone". Entrambe le classi implementano l'interfaccia "Tracciabile".
            if (veicolo instanceof Tracciabile) {
                
                // Faccio il casting di veicolo e lo assegno alla variabile tracciabilita per poter poi eseguire il metodo tracciabilita().
                // In parole semplici dico: so che veicolo è di tipo "VeicoloConsegna", ma trattalo come se fosse "Tracciabile":
                Tracciabile tracciabilita = (Tracciabile) veicolo;
                if (peso <= veicolo.caricoMassimo) {
                    
                    // Creo un oggetto di tipo Random per generare un numero casuale che rappresenterà il numero del tracking
                    Random trackCasuale = new Random();
                    // Genero un numero casuale compreso tra 1 e 10000:
                    String codiceTracking = "N-TRAKING-" + veicolo.targa + "-" + (i + 1) + trackCasuale.nextInt(1, 10001);
                    
                    // Grazie al casting di sopra posso chiamare il metodo tracciaConsegna(String codiceTracking) definito nell'interfaccia:
                    tracciabilita.tracciaConsegna(codiceTracking);
                }
            }
        }

        inputUtente.close(); // Chiudo lo stream di input dello Scanner
    }
}
