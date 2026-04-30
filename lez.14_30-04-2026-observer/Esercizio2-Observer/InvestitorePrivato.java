// Observer: oseervatore
public class InvestitorePrivato implements Investitore {
    private String name;

    // Costruttore:
    public InvestitorePrivato(String name) {
        this.name = name;
    }

    // Getter di name:
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void notifica(String azione, double valore) {
        System.out.println("L'investitore privato: " + this.name + " ha le azioni: " + azione
                + " che hanno un valore di: " + valore + " euro");
    }
}
