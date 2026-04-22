/* TESTO ESERCIZIO 
Gestione Semplice di una Autoofficina
Obiettivo: Allenati con la creazione e l’uso di classi e oggetti in Java.
Traccia:
Realizza almeno due classi:
- Classe Auto:
    - Attributi:
        - targa (String)
        - modello (String)
- Classe Officina:
    - Attributi:
        - Un array o un ArrayList di auto (Auto[] o ArrayList<Auto>)
        - Un metodo per aggiungere un’auto all’officina
        - Un metodo per stampare l’elenco di tutte le auto presenti

Obblighi minimi:
- Permetti di aggiungere almeno due auto diverse all’officina.
- Stampa a schermo l’elenco di tutte le auto con targa e modello
*/
public class Main {
    public static void main(String[] args) {

        Officina officina = new Officina();

        // Creo due auto
        Auto auto1 = new Auto("AB123CD", "Fiat Panda");
        Auto auto2 = new Auto("EF456GH", "Volkswagen Golf");

        // Le aggiungo all'officina
        officina.aggiungiAuto(auto1);
        officina.aggiungiAuto(auto2);

        // Stampo tutte le auto utilizzando l'override del metodo toString() nella classe Officina
        System.out.println(officina);
    }
}
