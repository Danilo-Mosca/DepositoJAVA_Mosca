// Facade
public class Facade {
    private Bios bios = new Bios();
    private HardDisk hd = new HardDisk();
    private SistemaOperativoContext sistemaOperativo = new SistemaOperativoContext();

    public void accendiComputer(){
        bios.inizializza();
        hd.carica();
        sistemaOperativo.performTask();
    }
}
