// Observer:
public class DisplayConsole implements Display {

    @Override
    public void aggiorna(float temperatura) {
        System.out.println("Console: temperatura aggiornata = " + temperatura + "°C");
    }
}