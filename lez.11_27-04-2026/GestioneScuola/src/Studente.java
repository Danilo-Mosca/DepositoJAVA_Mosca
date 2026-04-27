import java.util.ArrayList;
import java.util.List;

public class Studente extends Persona implements Registrabile {

    private String classeFrequentata;
    private List<Integer> voti = new ArrayList<>(); // ArrayList contenente tutti i voti degli studenti

    // Costruttore:
    public Studente(String nome, int eta, String classeFrequentata) {
        super(nome, eta);
        this.classeFrequentata = classeFrequentata;
    }

    // Getter e setter:
    public String getClasseFrequentata() {
        return classeFrequentata;
    }

    public void setClasseFrequentata(String classeFrequentata) {
        this.classeFrequentata = classeFrequentata;
    }

    // Implemento il metodo astratto della classe astratta Persona:
    @Override
    public void descriviRuolo() {
        System.out.println("Sono uno studente della classe: " + classeFrequentata);
    }

    // Implemento il metodo dell'interfaccia Registrabile:
    @Override
    public void registrazione() {
        System.out.println("Registrazione tramite modulo online");
    }

    // Metodo aggiungi voto:
    public void aggiungiVoto(int voto) {
        voti.add(voto);
    }

    // Metodo stampaVoti():
    public void stampaVoti() {
        System.out.println("Voti di " + getNome() + ": " + this.voti);
    }
}
