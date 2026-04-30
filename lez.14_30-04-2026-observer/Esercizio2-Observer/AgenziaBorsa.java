import java.util.ArrayList;
import java.util.List;

// AgenziaBorsa è il Subject, l'osservato:
public class AgenziaBorsa {
    private List<Investitore> investitori = new ArrayList<>();

    // Metodi:
    public void aggiungiInvestitore(Investitore investitore) {
        investitori.add(investitore);
    }

    // OLD CLASS:
    // public void rimuoviInvestitore(Investitore investitore) {
    //     investitori.remove(investitore.getName());
    // }

    public void rimuoviInvestitore(String name) {
        Investitore daRimuovere = null;

        for (Investitore i : investitori) {
            if (i.getName().equalsIgnoreCase(name)) {
                daRimuovere = i;
                break;
            }
        }

        if (daRimuovere != null) {
            investitori.remove(daRimuovere);
        }
        else {
            System.out.println("Non è stato possibile rimuovere l'investitore, non esiste!");
        }
    }

    public void notificaInvestitori(String azione, double valore) {
        for (Investitore inv : investitori) {
            inv.notifica(azione, valore);
        }
    }

    // Metodo che notifica gli investitori:
    public void aggiornaValoreAzione(String nome, double valore) {
        System.out.println("Aggiornamento azioni: " + nome + " = " + valore + " euro");
        notificaInvestitori(nome, valore);
    }
}
