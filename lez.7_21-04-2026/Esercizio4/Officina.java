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

    // Metodo per stampare tutte le auto
    public void stampaAuto() {
        for (Auto auto : autoList) {
            System.out.println("Targa: " + auto.targa + " - Modello: " + auto.modello);
        }
    }
}
