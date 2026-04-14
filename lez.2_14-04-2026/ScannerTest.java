import java.util.Scanner; // Importo la classe Scanner

public class ScannerTest {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);             // Crea un oggetto Scanner
        System.out.println("Enter username");

        String userName = myObj.nextLine();                 // Leggo un user input: nextLine() legge e accetta valori di tipo char e String
        System.out.println("Username is: " + userName);     // mando in output un testo e il valore inserito dall'utente che ho salvato nella variabile userName
    }
}
