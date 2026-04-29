/* ESERCIZIO: Design pattern ES Singleton

Progetta un logger centralizzato che possa essere usato da qualsiasi parte del programma per scrivere messaggi di log su console. Il logger deve essere implementato seguendo il pattern Singleton.

Requisiti:

Crea una classe Logger con:
    - Un campo privato statico per contenere l’unica istanza (private static Logger istanza)
    - Un costruttore privato
    - Un metodo statico pubblico GetIstanza() che restituisce sempre la stessa istanza
    - Un metodo ScriviMessaggio(string messaggio) che stampa il messaggio con data e ora

Nel Main:
    - Richiama Logger.GetIstanza() da almeno due punti distinti del codice
    - Usa ScriviMessaggio() per stampare messaggi diversi
    - Dimostra che si tratta sempre della stessa istanza (es. confrontando i riferimenti)
*/

public class Main {
    public static void main(String[] args) {
        /* Singleton di Logger: */

        // Creo l'instanza se non esiste già:
        Logger istanzaLogger1 = Logger.getIstanza();

        // Stampo il messaggio richiamando il metodo pubblico scriviMessaggio():
        istanzaLogger1.scriviMessaggio("Ciao");      // Primo messaggio
        istanzaLogger1.scriviMessaggio("Benvenuto!");      // Secondo messaggio

        // Provo a creare una seconda istanza ma otterrò sempre la stessa:
        Logger istanzaLogger2 = Logger.getIstanza();

        // Controllo il riferimento di istanza istanzaLogger1 e di istanzaLogger2:
        if(istanzaLogger1 == istanzaLogger2) {
            System.out.println("Sto richiamando la stessa istanza Logger");        // Visualizzerò sempre la stessa istanza
        }
        else {
            System.out.println("Sono due istanze diverse");
        }

        // A dimostrazione che sono la stessa istanza, se richiamo il metodo toString() punteranno entrambe allo stesso indirizzo di memoria:
        System.out.println(istanzaLogger1);
        System.out.println(istanzaLogger2);


        /* Singleton di Utente: */

        // Creo l'instanza se non esiste già:
        Utente istanzaUtente1 = Utente.getIstanza();

        // Stampo il messaggio richiamando il metodo pubblico scriviMessaggio():
        istanzaUtente1.scriviMessaggio("Eccomi!"); // Primo messaggio
        istanzaUtente1.scriviMessaggio("Sono l'istanza Utente!"); // Secondo messaggio

        // Provo a creare una seconda istanza ma otterrò sempre la stessa:
        Utente istanzaUtente2 = Utente.getIstanza();

        // Controllo il riferimento di istanza istanzaLogger1 e di istanzaLogger2:
        if (istanzaUtente1 == istanzaUtente2) {
            System.out.println("Sto richiamando la stessa istanza Utente"); // Visualizzerò sempre la stessa istanza
        } else {
            System.out.println("Sono due istanze diverse");
        }

        // A dimostrazione che sono la stessa istanza, se richiamo il metodo toString()
        // punteranno entrambe allo stesso indirizzo di memoria:
        System.out.println(istanzaUtente1);
        System.out.println(istanzaUtente2);

        // Confronto le istanze Logger e Utente:
        if(istanzaUtente1.equals(istanzaLogger1)){
            System.out.println("Sto richiamando la stessa istanza");    // Non verrà mai visualizzato
        }
        else{
            System.out.println("Sono due istanze diverse");
        }
    }
}
