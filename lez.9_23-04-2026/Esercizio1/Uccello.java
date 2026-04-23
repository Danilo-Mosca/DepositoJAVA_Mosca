public class Uccello extends Animale {

    public Uccello(String nome, int eta) {
        super(nome, eta);       // richiamo il costruttore della classe Animale per il riempimento dei dati
    }

    // Override del metodo faiVerso:
    @Override
    public void faiVerso() {
        System.out.println("Cip cip!");
    }
}