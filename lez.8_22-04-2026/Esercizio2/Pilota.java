public class Pilota {
    private String nome;
    private String numeroBrevetto;
    private int oreVolo;

    // Costruttore
    public Pilota(String nome, String numeroBrevetto, int oreVolo) {
        this.nome = nome;
        this.numeroBrevetto = numeroBrevetto;
        setOreVolo(oreVolo);
    }

    // Getter
    public String getNome() {
        return nome;
    }

    public String getNumeroBrevetto() {
        return numeroBrevetto;
    }

    public int getOreVolo() {
        return oreVolo;
    }

    // Setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumeroBrevetto(String numeroBrevetto) {
        this.numeroBrevetto = numeroBrevetto;
    }

    public void setOreVolo(int oreVolo) {
        if (oreVolo > 0) {
            this.oreVolo = oreVolo;
        } else {
            System.out.println("Ore di volo non valide!");
        }
    }

    //Override metodo toString()
    @Override
    public String toString() {
        return "Pilota: " +
                "nome='" + nome + '\'' +
                ", brevetto='" + numeroBrevetto + '\'' +
                ", oreVolo=" + oreVolo;
    }
}
