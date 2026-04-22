/* Esercizio Incapsulamento
Obiettivo:
Comprendere e applicare il concetto di incapsulamento in Java tramite l’uso di attributi privati e metodi getter/setter.
Traccia:
Crea una classe Studente con i seguenti attributi privati:
- nome (String)
- voto (int)
- id (int - statico - autoincrementante)

Implementa:
- Un costruttore per inizializzare nome e voto.
- Un metodo getter per leggere il nome.
- Un metodo getter per leggere il voto.
- Un metodo setter per modificare il voto, assicurandoti che il voto sia sempre compreso tra 0 e 10 (se fuori intervallo, non modificare e stampa un messaggio di errore).

Nel main:
- Crea un oggetto Studente.
- Stampa nome e voto iniziale.
- Prova a cambiare il voto con valori validi e non validi, stampando il risultato ogni volta.
- Gestire la lista di studenti tramite un arraylist
- rendere possibile la ricerca di uno studente tramite nome
 */

public class Studente {
    private String nome;
    private int voto;
    private static int id = 0;
    private int idStudente;

    // Costruttore:
    public Studente(String nome, int voto) {
        this.nome = nome;
        this.voto = voto;
        this.id++;          //ad ogni istanza incremento l'id statico
        this.idStudente = this.id;      //e poi lo assegno incrementato ad ogni nuovo studente che si registra (così genero un contatore simulando l'id del database)
    }

    // Getter e setter:
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVoto() {
        return this.voto;
    }

    public void setVoto(int voto) {
        if (voto >= 0 && voto <= 10) {
            this.voto = voto;
        } else {
            System.out.println("Errore nell'inserimento! Il voto deve essere compreso tra 0 e 10");
        }
    }

    public int getidStudente() {
        return this.idStudente;
    }

    // Medoti:
    // Metodo che controlla se il nome dello studente esiste:
    public boolean isStudent(String nome) {
        // con trim() tolgo gli spazi a destra e sinistra del nome che l'utente potrebbe
        // aver inserito per sbaglio
        // toLowerCase() imposto tutti i caratteri in minuscolo
        nome = nome.trim().toLowerCase();
        // Controllo se esiste:
        if (nome.equals(this.nome.trim().toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }
}
