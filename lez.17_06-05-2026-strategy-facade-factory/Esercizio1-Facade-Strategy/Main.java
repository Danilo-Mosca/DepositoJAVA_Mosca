/* ESERCIZIO Design pattern ES Facade
Esercizio Facile:
Obiettivo: Creare un sistema di accensione luci tramite Facade.
Richiesta:
- Crea due classi LuceCamera e LuceCucina con metodo accendi().
- Crea una classe GestioneLuciFacade che accende entrambe le luci tramite un unico metodo accendiTutte().
- In Main, istanzia il Facade e accendi tutte le luci con una sola chiamata. 

- Punto aggiuntivo: inserisci il design pattern Strategy ad esempio inserendo il colore della luce
*/

public class Main {

    public static void main(String[] args) {
        System.out.println("======== SENZA IL DESIGN PATTERN STRATEGY ========");
        // Istanzio la classe Facade
        GestioneLuciFacade appartamento = new GestioneLuciFacade();
        appartamento.accendiEntrambe();

        System.out.println("======== CON IL DESIGN PATTERN STRATEGY ========");
        // Utilizzo dello Strategy
        Context context = new Context();
        context.setStrategy(new LuceCamera());
        context.performTask();
        context.setStrategy(new LuceCucina());
        context.performTask();
    }
}