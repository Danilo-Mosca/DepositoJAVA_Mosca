package Controller;
import Model.Bevanda;
//Interfaccia Strategy Sconti
interface StrategySconti {
    //metodo per calcolare il prezzo con eventuali sconti
    public double processaSconti(Bevanda bevanda);
}
