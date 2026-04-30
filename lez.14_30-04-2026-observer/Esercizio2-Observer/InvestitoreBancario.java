// Observer: osservatore
public class InvestitoreBancario implements Investitore {
    private String name;

    // Costruttore:
    public InvestitoreBancario(String name) {
        this.name = name;
    }

    // Getter di name:
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void notifica(String azione, double valore) {
        System.out.println("La banca: " + this.name + " ha le azioni: " + azione
                + " che hanno un valore di: " + valore + " euro");
    }
}
