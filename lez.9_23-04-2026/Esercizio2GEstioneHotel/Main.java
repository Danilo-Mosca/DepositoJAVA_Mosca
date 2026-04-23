/* Esercizio: Gestione Semplice di un Hotel
Obiettivi:
- Applicare incapsulamento (attributi privati e getter/setter).
- Applicare ereditarietà (almeno una sottoclasse di una classe base).
- Usare l’overload (sovraccarico) di almeno un metodo.
- Usare almeno un metodo statico.

Traccia
- Classe base Camera
    - Attributi privati: numero (int), prezzo (float).
    - Metodi getter/setter per tutti gli attributi.
    - Metodo dettagli() che stampa info sulla camera.
    - Overload di dettagli():
        - Uno senza parametri: stampa tutto.
        - Uno con parametro booleano conPrezzo: se true stampa anche il prezzo, altrimenti solo numero.
- Sottoclasse Suite (estende Camera)
    - Attributo privato: serviziExtra (String).
    - Getter/setter per serviziExtra.
    - Override di dettagli(): stampa anche i servizi extra.
- Classe Hotel
    - Attributo privato: nome (String).
    - Attributo privato: lista di camere (ArrayList<Camera>).
    - Metodo per aggiungere una camera.
    - Metodo statico contaSuite(ArrayList<Camera> lista) che restituisce quante Suite ci sono nella lista.
Nelmain:
- Crea un hotel, aggiungi almeno 2 camere normali e 2 suite.
- Usa il metodo overload dettagli() in entrambe le forme.
Usa il metodo statico per contare quante suite ci sono.
- Stampa l’output.
*/

public class Main {

    public static void main(String[] args) {
        Hotel hotel = new Hotel("Bulgari Hotel Roma");

        /* Aggiungi almeno 2 camere normali e 2 suite */
        // Camere normali
        Camera camera1 = new Camera(101, 80.0f);
        Camera camera2 = new Camera(102, 90.0f);

        // Aggiungo due Suite
        Suite suite1 = new Suite(201, 150.0f, "Jacuzzi");
        Suite suite2 = new Suite(202, 200.0f, "Vista mare");

        // Aggiungo tutte le camere all'hotel:
        hotel.aggiungiCamera(camera1);
        hotel.aggiungiCamera(camera2);
        hotel.aggiungiCamera(suite1);
        hotel.aggiungiCamera(suite2);

        // Uso overload:
        // Visualizzo prima la camera tramite il metodo dettagli() senza parametri
        camera1.dettagli(); // tutto
        // Poi visualizzo il metodo dettagli(boolean true) con i parametri:
        camera2.dettagli(false); // solo numero
        camera2.dettagli(true); // con prezzo

        // Override
        // Qui visualizzo il metodo dettagli() sovrascritto nella classe Suite:
        suite1.dettagli();
        suite2.dettagli();

        // Uso il metodo statico per contare quante suite ci sono e lo stampo a schermo:
        int numeroSuite = Hotel.contaSuite(hotel.getCamere());
        System.out.println("Numero di suite: " + numeroSuite);
    }
}