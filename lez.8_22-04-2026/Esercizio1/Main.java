import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inputStudent = new Scanner(System.in); // Crea un oggetto Scanner

        Studente studente = new Studente("Alessio", 8);

        // PROVA FUNZIONAMENTO OGGETTO:
        // System.out.println("Nome studente: " + studente.getNome());
        // System.out.println("Voto studente: " + studente.getVoto());

        // studente.setVoto(30);
        // studente.setVoto(9);
        // System.out.println("Voto studente cambiato: " + studente.getVoto());

        // ArrayList:
        ArrayList<Studente> listaStudenti = new ArrayList<>();
        listaStudenti.add(studente);
        Studente studente2 = new Studente("Marco", 5);
        Studente studente3 = new Studente("Francesca", 7);
        Studente studente4 = new Studente("Giada", 10);
        listaStudenti.add(studente2);
        listaStudenti.add(studente3);
        listaStudenti.add(studente4);

        boolean isExist = false; // Variabile che conterrà true se lo studente viene trovato in modo da
                                 // interrompere il "ciclo for" in anticipo
        boolean searchStudent = false; // variabile che ci dirà se lo studente è stato trovato

        do {
            System.out.println("\n======== MENU ========");
            System.out.println("1. Trova studente");
            System.out.println("2. Inserisci studente");
            System.out.println("3. Esci");
            System.out.print("Scelta: ");
            String sceltaUtente = inputStudent.nextLine(); // Leggo un user input: nextLine() legge e accetta valori di
                                                           // tipo String

            switch (sceltaUtente) {
                case "1":
                    System.out.print("Inserisci il nome dello studente da ricercare: ");
                    String choiseStudent = inputStudent.nextLine();
                    // For che controlla l'esistenza dello studente:
                    for (int i = 0; i < listaStudenti.size() && !isExist; i++) {
                        if (listaStudenti.get(i).isStudent(choiseStudent)) {
                            studentSelected(listaStudenti, i);
                            searchStudent = true; // Imposto searchStudent a true per indicare che lo studente è stato
                                                  // trovato
                        }
                    }
                    if (!searchStudent) {
                        System.out.println("Studente non trovato");
                    }
                    break;

                case "2":
                    insertStudent(listaStudenti, inputStudent);
                    break;

                case "3":
                    isExist = true; // Se chiedo di uscire, automaticamente la variabile verrà impostata a true per
                                    // uscire dal ciclo
                    break;

                default:
                    System.out.println("Hai inserito un valore non valido (inserisci 1 - 2 - 3)");
                    break;
            }
            searchStudent = false;      //Prima di riavviare il ciclo reimposto searchStudent a false 
        } while (!isExist);

        inputStudent.close();   // Chiudo lo Scanner "inputStudent" e libero le risorse
    }

    // Metodo statico che visualizza i dati dell'utente ricercato:
    public static void studentSelected(ArrayList<Studente> listaStudenti, int i) {
        System.out.println("Lo studente selezionato è il seguente:\nNome: " + listaStudenti.get(i).getNome()
                + "\nVoto: " + listaStudenti
                        .get(i).getVoto());
    }

    // Metodo statico che permette l'inserimento di un nuovo utente:
    public static void insertStudent(ArrayList<Studente> listaStudenti, Scanner inputStudent){
        System.out.print("Inserisci il nome del nuovo studente: ");
        String student = inputStudent.nextLine();

        System.out.println();
        System.out.print("Inserisci il voto del nuovo studente: ");
        int vote = inputStudent.nextInt();
        while (!(vote >= 0 && vote <= 10)) {
            System.out.print("Hai inserito un voto non valido! Il voto deve essere compreso tra 0 e 10: ");
            vote = inputStudent.nextInt();
        }
        
        inputStudent.nextLine();    //pulizia buffer

        Studente newStudent = new Studente(student, vote);
        listaStudenti.add(newStudent);
    }
}
