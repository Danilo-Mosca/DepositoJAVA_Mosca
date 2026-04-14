public class OperatoriConfronto {

    public static void main(String[] args) {
        int a = 10;
        int b = 10;

        // Operatore di uguaglianza (verifica se "a" e "b" sono uguali)
        System.out.println(a == b); // restituirà true
        // Operatore minore:
        System.out.println(a < b); // restituirà false
        
        a = 7;
        b = 8;
        // Operatore minore uguale:
        System.out.println(a <= b); // restituirà true
        // Operatore maggiore:
        System.out.println(a > b); // restituirà false
        a = 8;
        // Operatore maggiore uguale:
        System.out.println(a >= b); // restituirà true
        // Operatore diverso:
        System.out.println(a != b); // restituirà false, perchè a e b sono uguali non diversi
    }
}