public abstract class Persona {

    private String nome;
    private int eta;

    // Costruttore:
    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    // Getter e setter:
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return this.eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    // metodo astratto:
    public abstract void descriviRuolo();
}
