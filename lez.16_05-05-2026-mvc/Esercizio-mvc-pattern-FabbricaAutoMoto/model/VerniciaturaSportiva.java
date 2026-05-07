package model;
// Decoratore concreto "VerniciaturaSportiva" che estende la classe astratta decorator "VeicoloDecorator"

public class VerniciaturaSportiva extends VeicoloDecorator{
    // Costruttore
    public VerniciaturaSportiva(Veicolo veicolo){
        super(veicolo);
    }

    @Override
    public String getDescrizione(){
        return veicolo.getDescrizione() + " con verniciatura sportiva";
    }
}