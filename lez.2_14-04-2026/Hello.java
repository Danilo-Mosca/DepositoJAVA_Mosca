public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello world!"); // riga prinln che stampa la riga tra virgolette e poi va accapo
        System.out.print("Riga che non va accapo"); // riga print che stampa la riga tra virgolette e poi non va accapo
        System.out.println(" riga adiacente a quella non accapo");

        System.out.println(3 + 3);

        // Come si scrive una variabile: type variableName = value;
        // Queste sono variabili complete:
        int provaNumero = 12;
        String provaTesto = "Ciao Mondo";
        boolean provaBool = true;

        // Questa è una variabile definita:
        boolean provaBoolean;
        provaBoolean = false;
        provaBoolean = true;

        // Questa è una costante:
        final int provaCostante = 15;

        // Il "+" è un operatore che cambia in maniera polimorfica: ovvero in base al
        // contenuto con cui ha a che fare:
        String testo = "Mondo";
        System.out.println("Ciao " + testo); // aggiunge entrambe le stringhe
        String firstPart = "Ciao ";
        String lastPart = "Mondo";
        String fullPart = firstPart + lastPart;
        System.out.println(fullPart);

        System.out.println(2 + "prova"); // con un tipo numerico e un tipo stringa l'operatore + unisce questi due
                                         // valori come fossero una stringa

        // Definizione delle variabili a cascata:
        // A riga univoca:
        int x = 5, y = 6, z = 50;
        System.out.println(x + y + z);

        // A Cascata:
        int a, b, c;
        a = b = c = 50;
        System.out.println(a + b + c);

        // I TIPI DI DATI CON LA VIRGOLA (FLOAT E DOUBLE) DEVONO ESSERE SPECIFICATO CON UNA "f" O una "d" FINALE:
        float myFLoat = 5.75f;
        double myDouble = 19.99d;

        // E' UNA BEST PRACTICE "DEFINIRE SEMPRE I BOOLEANI" UNA VOLTA DICHIARATI:
        boolean isJava = true;
        boolean isFerrari = false;
    }
}