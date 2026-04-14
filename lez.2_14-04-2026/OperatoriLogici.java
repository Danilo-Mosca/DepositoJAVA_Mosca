public class OperatoriLogici {
    public static void main(String[] args) {
        int x = 7;

        // Operatore AND &&:
        System.out.println(x < 3 && x < 10); // resituirà false perchè x essendo 7 non è minore di 5

        x = 3;
        // Operatori OR ||:
        System.out.println(x < 5 || x < 4); // restituirà true perchè è minore sia di 5 che di 4
        // Operatore NOT !:
        System.out.println(!(x < 5 && x < 10)); // restituirà false perchè è vero che x è nimore sia di 5 che di 10, ma dopo c'è il not (!) e quindi la negazione del risultato: true diventa false e false diventa true
    }
}
