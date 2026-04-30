import java.util.ArrayList;
import java.util.List;

// StazioneMeteo è il Subject, l'osservato
public class StazioneMeteo {

    private List<Display> displays;
    private float temperatura;

    // Costruttore:
    public StazioneMeteo(){
        displays = new ArrayList<>();
    }

    // Metodi:
    public void aggiungiDisplay(Display d) {
        displays.add(d);
    }

    public void rimuoviDisplay(Display d) {
        displays.remove(d);
    }

    public void notificaDisplay() {
        for (Display singleDisplay : displays) {
            singleDisplay.aggiorna(temperatura);
        }
    }

    // Ogni volta che chiamo questo metodo aggiorno lo stato e notifico tutti i display:
    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
        notificaDisplay();
    }
}
