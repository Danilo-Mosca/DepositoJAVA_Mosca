abstract class VeicoloConsegna {
    protected String targa;
    protected float caricoMassimo;

    // Costruttore:
    public VeicoloConsegna(String targa, float caricoMassimo) {
        this.targa = targa;
        this.caricoMassimo = caricoMassimo;
    }

    public abstract void consegnaPacco(String destinazione, float peso);     //Metodo astratto

    // Metodi concreti:
    public void stampaInfo(){
        System.err.println("Veicolo con targa: " + targa + " - Carico massimo: " + caricoMassimo);
    }
}