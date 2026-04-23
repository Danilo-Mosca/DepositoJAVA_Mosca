import java.util.ArrayList;

public class Hotel {

    private String nome;
    private ArrayList<Camera> listaCamere;

    public Hotel(String nome) {
        this.nome = nome;
        this.listaCamere = new ArrayList<>();
    }

    public ArrayList<Camera> getCamere() {
        return listaCamere;
    }

    public void aggiungiCamera(Camera camera) {
        listaCamere.add(camera);
    }

    // Metodo statico contaSuite() che restituisce quante Suite ci sono nella lista:
    public static int contaSuite(ArrayList<Camera> lista) {
        int count = 0;
        // Ciclo le camere per vedere quante istanza di Suite ci sono in esse:
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) instanceof Suite) {
                count++;
            }
        }
        return count;
    }
}
