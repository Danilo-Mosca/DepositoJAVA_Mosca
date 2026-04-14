public class StruttureCondizionali {
    public static void main(String[] args) {
        int x = 20;
        int y = 18;
        // if senza else:
        if (x > y) {
            System.out.println("x è più grande di y");
        }

        // if con else:
        int time = 20;
        if (time < 18) {
            System.out.println("Buongiorno");
        } else {
            System.out.println("Buonasera"); // verrà stampato questo output
        }

        // else if (gli else if devono essere autoescludenti: uno deve escludere
        // l'altro):
        time = 22;
        if (time < 10) {
            System.out.println("Buongiorno");
        } else if (time < 18) {
            System.out.println("Buon pomeriggio");
        } else {
            System.out.println("Buonasera"); // verrà stampato questo output
        }

        // Si possono avere anche if dentro un altro if, si chiama if annidato:
        if (x == y) {
            if (x != y) {
            }
        }
        
    }
}
