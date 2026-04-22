import java.util.ArrayList;

public class Officina {
    public ArrayList<Auto> autoList;

    // Costruttore di default:
    public Officina() {
        autoList = new ArrayList<>();
    }

    // Metodo per aggiungere un'auto
    public void aggiungiAuto(Auto auto) {
        autoList.add(auto);
    }

    // Metodo per stampare tutte le auto (override del metodo ereditato toString())
    @Override
    public String toString() {
        String variabileAppoggio = "";
        for (Auto auto : autoList) {
            variabileAppoggio += "Targa: " + auto.targa + " - Modello: " + auto.modello + "\n";
        }
        return variabileAppoggio;
    }
}
