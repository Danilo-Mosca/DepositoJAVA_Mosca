package model;
// Facade
public class ComputerFacade {
    private Bios bios ;
    private HardDisk hd;
    private SistemaOperativoContext sistemaOperativoContext;

    // Costruttore della Facade
    public ComputerFacade(SistemaOperativoContext sistemaOperativoContext){
        this.bios = new Bios();
        this.hd = new HardDisk();
        this.sistemaOperativoContext = sistemaOperativoContext;
    }

    public void accendiComputer(){
        bios.inizializza();
        hd.carica();
        sistemaOperativoContext.avviaSistema();
    }
}