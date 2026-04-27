import java.util.ArrayList;
import java.util.List;

public class Docente extends Persona implements Registrabile {

    private String materia;
    private List<Studente> listaStudentiMateria = new ArrayList<>(); // ArrayList di tipo "Studente" contenente la lista
                                                                     // degli studenti per quella materia

    // Costruttore:
    public Docente(String nome, int eta, String materia) {
        super(nome, eta);
        this.materia = materia;
    }

    // Getter e setter:
    public String getMateria() {
        return materia;
    }

    // Metodo che ritorna la lista degli studenti assegnati per quel professore:
    public List<Studente> getStudentiAssegnati() {
        return listaStudentiMateria;
    }

    // Implemento il metodo astratto della classe astratta Persona:
    @Override
    public void descriviRuolo() {
        System.out.println("Sono un docente di: " + this.materia);
    }

    // Implemento il metodo dell'interfaccia Registrabile:
    @Override
    public void registrazione() {
        System.out.println("Registrazione tramite segreteria didattica");
    }

    // Metodo che assegna i voti:
    public void assegnaVoti(Studente stud, int voto) {
        stud.aggiungiVoto(voto);
        System.out.println("Voto assegnato allo studente: " + stud.getNome());
    }

}
