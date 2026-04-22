import java.util.ArrayList;

public class CompagniaAerea {
    private String nome;
    private ArrayList<Aereo> flotta;
    private ArrayList<Pilota> piloti;

    // Costruttore
    public CompagniaAerea(String nome) {
        this.nome = nome;
        this.flotta = new ArrayList<>();
        this.piloti = new ArrayList<>();
    }

    // Metodo per aggiungere aereo
    public void aggiungiAereo(Aereo aereo) {
        flotta.add(aereo);
    }

    // Metodo per aggiungere pilota
    public void aggiungiPilota(Pilota pilota) {
        piloti.add(pilota);
    }

    // Metodo per stampare informazioni
    public void stampaInformazioni() {
        System.out.println("Compagnia: " + nome);

        System.out.println("\n--- Flotta ---");
        for (Aereo a : flotta) {
            System.out.println(a); // usa l'override di toString() di Aereo automaticamente
        }

        System.out.println("\n--- Piloti ---");
        for (Pilota p : piloti) {
            System.out.println(p); // usa l'override di toString() di Pilota automaticamente
        }
    }
}