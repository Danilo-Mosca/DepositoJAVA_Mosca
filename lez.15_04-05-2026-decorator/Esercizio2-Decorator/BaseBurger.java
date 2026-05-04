// Classe concreta che implementa l'interfaccia Hamburger
public class BaseBurger implements Hamburger{
    @Override
    public String getDescrizione(){
        return "Hamburger semplice";
    }

    @Override
    public double getPrezzo(){
        return 5.0;
    }
}
