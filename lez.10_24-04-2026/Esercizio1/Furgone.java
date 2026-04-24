public class Furgone extends VeicoloConsegna implements Tracciabile {

    public Furgone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    // Override del metodo astratto nella classe astratta VeicoloConsegna:
    @Override
    public void consegnaPacco(String destinazione, float peso) {
        if (peso > this.caricoMassimo) {
            System.out.println("Errore: carico troppo pesante per il furgone!");
        } else {
            System.out.println("Il Furgone con targa: " + targa + " sta consegnando in via: " + destinazione);
        }
    }

    // Override del metodo tracciaConsegna() presente nell'interfaccia Tracciabile:
    @Override
    public void tracciaConsegna(String codiceTracking) {
        System.out.println("Il tracking del Furgone è il seguente: " + codiceTracking + " sta consegnando su strada");
    }
}
