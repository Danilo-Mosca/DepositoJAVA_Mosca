/* TESTO ESERCIZIO
Definire una Classe BankAccount e Implementare Deposito & Prelievo

Crea una classe BankAccount con:
- String accountHolderName (Nome del titolare dell'account)
- double balance (Saldo)

- Metodo void deposit(double amount) per effettuare un deposito
- Metodo void withdraw(double amount) per effettuare un prelievo
- Metodo void displayBalance() per mostrare il saldo attuale

Assicurati che il prelievo non consenta un saldo negativo.
Extra: andare a creare un arraylist di account tra cui scegliere in base alle credenziali 
*/

public class BankAccount {
    // Attributi
    String accountHolderName;   //Nome del titolare dell'account
    double balance;             //saldo

    // Costruttore di default:
    public BankAccount(){
        this.accountHolderName = "Nome utente non disponibile";
        this.balance = 0.00d;
    }
    
    // Costruttore con parametri:
    public BankAccount(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    
    // Metodi:
    // Metodo per il deposito di denaro:
    public void deposit(double amount){
        this.balance += amount;
        System.out.println("Deposito eseguito");
    }

    // Metodo per il prelievo di denaro:
    public void withdraw(double amount) {
        if(this.balance - amount < 0){
            System.out.println("Prelievo non disponibile, saldo isufficiente!");
        }
        else {
            this.balance -= amount;
            System.out.println("Prelievo di euro " + amount + " effettuato!");
        }
    }

    // Metodo che mostra il saldo attuale:
    public void displayBalance() {
        System.out.println("Il tuo saldo è di euro " + this.balance);
    }

    // Metodo che controlla se l'account utente esiste:
    public boolean isUser(String user){
        // Vado a modificare il valore ricevuto come parametro in questo modo:
        // con trim() tolgo gli spazi a destra e sinistra del nome che l'utente potrebbe aver inserito per sbaglio
        // toLowerCase() imposto tutti i caratteri in minuscolo
        // infine .replace(" ", "") toglie tutti gli spazi interni alla stringa
        user = user.trim().toLowerCase().replace(" ", "");
        // Faccio lo stesso con accountHolderName ma solo al confronto nel metodo equals:
        if(user.equals(accountHolderName.trim().toLowerCase().replace(" ", ""))){
            return true;
        }
        else{
            return false;
        }
    }
}