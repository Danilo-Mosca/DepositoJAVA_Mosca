public class Suite extends Camera {
    private String serviziExtra;

    public Suite(int numero, float prezzo, String serviziExtra){
        super(numero,prezzo);       // richiamo il costruttore della classe Camera per il riempimento dei dati
        this.serviziExtra = serviziExtra;
    }

    // Getter e setter:
    public String getServiziExtra(){
        return this.serviziExtra;
    }
    
    public void setServiziExtra(String serviziExtra) {
        this.serviziExtra = serviziExtra;
    }

    // Override di dettagli():
    @Override
    public void dettagli() {
        System.out.println("Camera numero: " + getNumero() + ", Prezzo: " + getPrezzo() + ", Servizi extra: " + serviziExtra);
    }
}
