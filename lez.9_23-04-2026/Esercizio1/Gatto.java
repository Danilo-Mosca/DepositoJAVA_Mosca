public class Gatto extends Animale {

    public Gatto(String nome, int eta) {
        super(nome, eta);       // richiamo il costruttore della classe Animale per il riempimento dei dati
    }

    // Override del metodo faiVerso:
    @Override
    public void faiVerso() {
        System.out.println("Miao!");
    }
}