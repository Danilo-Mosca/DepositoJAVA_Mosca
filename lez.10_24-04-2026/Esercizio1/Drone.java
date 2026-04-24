public class Drone extends VeicoloConsegna implements Tracciabile {

    public Drone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    // Override del metodo astratto nella classe astratta VeicoloConsegna:
    @Override
    public void consegnaPacco(String destinazione, float peso) {
        if (peso > this.caricoMassimo) {
            System.out.println("Errore: carico troppo pesante per il drone!");
        } else {
            System.out.println("Il Drone con targa: " + targa + " sta consegnando in via: " + destinazione);
        }
    }

    // Override del metodo tracciaConsegna() presente nell'interfaccia Tracciabile:
    @Override
    public void tracciaConsegna(String codiceTracking) {
        System.out.println("Il tracking del Drone è il seguente: " + codiceTracking + " sta consegnando in volo");
    }
}
