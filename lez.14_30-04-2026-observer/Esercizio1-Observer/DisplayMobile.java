// Observer:
public class DisplayMobile implements Display {

    @Override
    public void aggiorna(float temperatura) {
        System.out.println("Mobile: nuova temperatura = " + temperatura + "°C");
    }
}