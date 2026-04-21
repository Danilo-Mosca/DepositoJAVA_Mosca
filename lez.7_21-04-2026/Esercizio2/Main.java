public class Main {
    public static void main(String[] args) {
        
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Paolo", 23);
        Persona persona3 = new Persona("Marco", 29, "Roma");
        Persona persona4 = new Persona("Riccardo", 26, "Milano");

        persona1.mostraPersona();
        persona2.mostraPersona();
        persona3.mostraPersona();
        persona4.mostraPersona();
    }
}
