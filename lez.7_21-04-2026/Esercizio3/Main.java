import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputUtente = new Scanner(System.in); // Crea un oggetto Scanner

        BankAccount utente1 = new BankAccount(); // Costruttore di default
        BankAccount utente2 = new BankAccount("Paolo Rossi", 100);
        BankAccount utente3 = new BankAccount("Riccardo Verdi", 150);
        BankAccount utente4 = new BankAccount("Francesco Gialli", 30);
        BankAccount utente5 = new BankAccount("Danilo Mosca", 500);
        BankAccount utente6 = new BankAccount("Tizio", 1500);
        BankAccount utente7 = new BankAccount("Caio", 10);

        // Provo a richiamare i metodi della classe BankAccount per l'utente1:
        utente1.withdraw(20);
        utente1.deposit(100);
        utente1.withdraw(20);
        utente1.displayBalance();

        // Creo un ArrayList che conterrà i vari account creati precedentemente:
        ArrayList<BankAccount> listaTitolariAccount = new ArrayList<>();
        // Aggiungo gli oggetti utenti all'arrayList:
        listaTitolariAccount.add(utente1);
        listaTitolariAccount.add(utente2);
        listaTitolariAccount.add(utente3);
        listaTitolariAccount.add(utente4);
        listaTitolariAccount.add(utente5);
        listaTitolariAccount.add(utente6);
        listaTitolariAccount.add(utente7);

        boolean isExist = false; // Variabile che conterrà true se l'utente viene trovato in modo da interrompere
                                 // il "ciclo for" in anticipo

        // Variabile di appoggio che conterrà l'indice del titolare del conto corrente
        // se esistente:
        int indiceIsExist = -1; // Imposto -1 di default se nel caso non trovassi il nome dell'utente
        do {
            System.out.print("Inserisci il nome del titolare del conto corrente: ");
            String accountUtente = inputUtente.nextLine();  // Leggo un user input: nextLine() legge e accetta valori di tipo String.
            
            // For che controlla l'esistenza dell'utente:
            for (int i = 0; i < listaTitolariAccount.size() && !isExist; i++) {
                if (listaTitolariAccount.get(i).isUser(accountUtente)) {
                    isExist = true; // Se l'utente viene trovato assegno true
                    indiceIsExist = i; // Se l'utente esiste assegno la sua posizione nell'arrayList ad una variabile
                                       // di appoggio così da accedervi successivamente
                }
            }

            // Se l'utente non esiste mando a schermo un messaggio:
            if (!isExist) {
                System.out.println("Titolare del conto corrente non trovato");
            }
        } while (!isExist); // Ciclo infinito se l'utente non viene trovato. Simulo un bancomat che è sempre
                            // in attesa di qualcosa

        inputUtente.close(); // Chiudo lo Scanner "inputUtente" e libero le risorse

        /*
         * Se il valore di indiceIsExist è diverso da -1 (il valore impostato da me di
         * default), allora significa che l'utente è stato trovato
         * e quindi posso eseguire tutte le istruzioni relative al suo conto corrente
         */
        if (indiceIsExist != -1)
            System.out.println("Nome utente esistente: " + listaTitolariAccount.get(indiceIsExist).accountHolderName);
        // Successivamente eseguo le operazioni per quel determinato utente:
        listaTitolariAccount.get(indiceIsExist).withdraw(50);
        listaTitolariAccount.get(indiceIsExist).deposit(180);
        listaTitolariAccount.get(indiceIsExist).withdraw(80);
        listaTitolariAccount.get(indiceIsExist).displayBalance();
    }
}
