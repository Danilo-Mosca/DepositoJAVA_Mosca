import java.util.ArrayList;

public class Zoo {

    private ArrayList<Cane> cani = new ArrayList<>();
    private ArrayList<Gatto> gatti = new ArrayList<>();
    private ArrayList<Uccello> uccelli = new ArrayList<>();

    public void aggiungiCane(Cane cane) {
        cani.add(cane);
    }

    public void aggiungiGatto(Gatto gatto) {
        gatti.add(gatto);
    }

    public void aggiungiUccello(Uccello uccello) {
        uccelli.add(uccello);
    }

    public void stampaZoo() {
        System.out.println("--- CANI ---");
        // Foreach:
        for (Cane c : cani) {
            System.out.print("Nome animale: " + c.getNome() + " - età: " + c.getEta() + " - verso: ");
            c.faiVerso();
        }

        System.out.println("--- GATTI ---");
        // Foreach:
        for (Gatto g : gatti) {
            System.out.print("Nome animale: " + g.getNome() + " - età: " + g.getEta() + " - verso: ");
            g.faiVerso();
        }

        System.out.println("--- UCCELLI ---");
        // Foreach:
        for (Uccello u : uccelli) {
            System.out.print("Nome animale: " + u.getNome() + " - età: " + u.getEta() + " - verso: ");
            u.faiVerso();
        }
    }
}