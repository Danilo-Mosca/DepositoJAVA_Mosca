/* Esercizio: Gestione Flotta di una Compagnia Aerea (Incapsulamento)
Obiettivo:
Allenati con l’incapsulamento in Java usando almeno tre classi collegate tra loro nel dominio dell’aeronautica.

Traccia:
Crea queste tre classi:
- Aereo
    - Attributi privati:
        - modello (String)
        - numeroPosti (int)
        - codice (String, identificativo dell’aereo)
    - Getter e setter per tutti gli attributi (il setter di numeroPosti deve accettare solo valori positivi).
- Pilota
    - Attributi privati:
        - nome (String)
        - numeroBrevetto (String)
        - oreVolo (int)
    - Getter e setter per tutti gli attributi (il setter di oreVolo deve accettare solo valori maggiori di zero).
- CompagniaAerea
    - Attributi privati:
        - nome (String)
        - flotta (ArrayList di oggetti Aereo)
        - piloti (ArrayList di oggetti Pilota)
    - Metodo per aggiungere un aereo alla flotta.
    - Metodo per aggiungere un pilota.
    - Metodo per stampare tutte le informazioni sulla flotta e i piloti della compagnia.

Obblighi minimi:
- Crea almeno due aerei e due piloti e aggiungili alla compagnia aerea.
- Stampa a schermo le informazioni della compagnia, mostrando dati di aerei e piloti.
*/
public class Main {
    public static void main(String[] args) {

        CompagniaAerea compagnia = new CompagniaAerea("Emirates");

        // Creazione aerei
        Aereo a1 = new Aereo("Boeing 737", 180, "A001");
        Aereo a2 = new Aereo("Airbus A320", 160, "A002");

        // Creazione piloti
        Pilota p1 = new Pilota("Mario Rossi", "BR123", 1500);
        Pilota p2 = new Pilota("Luca Bianchi", "BR456", 2000);

        // Aggiunta alla compagnia
        compagnia.aggiungiAereo(a1);
        compagnia.aggiungiAereo(a2);

        compagnia.aggiungiPilota(p1);
        compagnia.aggiungiPilota(p2);

        // Stampa
        compagnia.stampaInformazioni();
    }
}
