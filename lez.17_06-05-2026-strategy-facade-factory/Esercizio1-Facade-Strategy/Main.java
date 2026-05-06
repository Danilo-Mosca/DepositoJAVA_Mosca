public class Main {

    public static void main(String[] args) {
        System.out.println("======== SENZA IL DESIGN PATTERN STRATEGY ========");
        // Istanzio la classe Facade
        GestioneLuciFacade appartamento = new GestioneLuciFacade();
        System.out.println("Accendo tutte le luci delle stanze con le Facade:");
        appartamento.accendiTutte();

        System.out.println("======== CON IL DESIGN PATTERN STRATEGY ========");
        // Utilizzo dello Strategy
        // Mostro più informazioni con lo Strategy
        System.out.println("Ulteriori informazioni con lo Strategy:");
        Context context = new Context();
        context.setStanza(new LuceCamera());
        context.getColoreDurataLuce();
        context.setStanza(new LuceCucina());
        context.getColoreDurataLuce();
    }
}