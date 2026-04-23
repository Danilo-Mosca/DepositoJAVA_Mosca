public class Camera {

    private int numero;
    private float prezzo;

    // Costruttore:
    public Camera(int numero, float prezzo) {
        this.numero = numero;
        this.prezzo = prezzo;
    }

    // Getter e setter:
    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    // Metodi:
    public void dettagli() {
        System.out.println("Camera numero: " + numero + ", Prezzo: " + prezzo);
    }

    // Overloading:
    public void dettagli(boolean conPrezzo) {
        if (conPrezzo) {
            System.out.println("Camera numero: " + numero + ", Prezzo: " + prezzo);
        } else {
            System.out.println("Camera numero: " + numero);
        }
    }
}
