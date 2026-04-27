import java.util.ArrayList;
import java.util.Scanner;

public class GestioneScuola {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Crea un oggetto Scanner per l'inserimento dei dati

        // ArrayList che conterrà la lista dei docenti aggiunti:
        ArrayList<Docente> docenti = new ArrayList<>();
        // ArrayList che conterrà la lista degli studenti aggiunti:
        ArrayList<Studente> studenti = new ArrayList<>();
        boolean isTrue = true; // variabile condizionale del ciclo

        // Ciclo infinito (fino a quanto l'utente decide di uscire) per il menù:
        while (isTrue) {
            System.out.println("\n===== MENU SCUOLA =====");
            System.out.println("1. Crea Docente");
            System.out.println("2. Crea Studente");
            System.out.println("3. Assegna Voto");
            System.out.println("4. Stampa Voti Studente");
            System.out.println("5. Lista Docenti");
            System.out.println("6. Lista Studenti");
            System.out.println("7. Esci");

            String scelta = scanner.nextLine();

            switch (scelta) {

                case "1":
                    System.out.print("Nome docente: ");
                    String nomeDocente = scanner.nextLine();

                    System.out.print("Età docente: ");
                    int etaDocente = scanner.nextInt();
                    scanner.nextLine(); // pulisco il buffer
                    
                    System.out.print("Materia: ");
                    String materia = scanner.nextLine();

                    docenti.add(new Docente(nomeDocente, etaDocente, materia));

                    System.out.println("Docente creato!");
                    break;

                case "2":
                    System.out.print("Nome studente: ");
                    String nomeStudente = scanner.nextLine();

                    System.out.print("Età studente: ");
                    int etaStudente = scanner.nextInt();
                    scanner.nextLine(); // pulisco il buffer
                    
                    System.out.print("Classe: ");
                    String classe = scanner.nextLine();

                    studenti.add(new Studente(nomeStudente, etaStudente, classe));

                    System.out.println("Studente creato!");
                    break;

                case "3":
                    // Prima controllo se sono presenti docenti, altrimenti non potrei inserire i
                    // voti per quella determinata materia:
                    if (docenti.size() > 0) {
                        System.out.println("Scegli docente:");

                        for (int i = 0; i < docenti.size(); i++) {
                            System.out.println(i + " - " + docenti.get(i).getNome());
                        }
                        int d = scanner.nextInt();
                        scanner.nextLine(); // pulisco il buffer

                        Docente doc = docenti.get(d);

                        // 1)Se i docenti sono presenti, controllo a sua volta prima se sono presenti gli studenti per quella materia a cui aggiungere il voto:
                        if (studenti.size() > 0) {
                            boolean isPresent = false;      //Variabile booleana che controlla la presenza di almeno uno studente per quella materia nel ciclo for
                            for (int i = 0; i < studenti.size(); i++) {
                                // 2)Se gli studenti sono presenti, controllo nell'ArrayList "studenti" se sono presenti studenti iscritti a quella specifica materia a cui voglio assegnare il corso e mostro l'eventuale lista:
                                if (studenti.get(i).getClasseFrequentata().contains(doc.getMateria())) {
                                    isPresent = true;
                                    System.out.println(i + " - " + studenti.get(i).getNome());
                                }
                            }
                            // 3)Se è presente almeno uno studente nella lista allora chiedo all'utente di scegliere per quale di questo/i assegnare il voto:
                            if(isPresent){
                                System.out.println("Scegli studente:");
                                int s = scanner.nextInt();
                                scanner.nextLine(); // pulisco il buffer
                                System.out.print("Inserisci voto: ");
                                int voto = scanner.nextInt();
                                scanner.nextLine(); // pulisco il buffer
                                doc.assegnaVoti(studenti.get(s), voto);
                            }
                            else {
                                System.out.println("Non ci sono studenti per questa materia!");
                            }
                        } 
                        // Se invece non sono presenti studenti iscritti per quella materia, allora stampo un messaggio:
                        else {
                            System.out.println("Devi inserire prima almeno uno studente!");
                        }
                    } else {
                        System.out.println("Devi inserire prima almeno un docente!");
                    }
                    break;

                case "4":
                    // Prima di stampare i voti degli studenti controllo se questi siano presenti nell'ArrayList studenti:
                    if (studenti.size() > 0) {

                        System.out.println("Scegli studente:");
                        for (int i = 0; i < studenti.size(); i++) {
                            System.out.println(i + " - " + studenti.get(i).getNome());
                        }
                        int id = scanner.nextInt();
                        scanner.nextLine(); // pulisco il buffer

                        studenti.get(id).stampaVoti();
                    } else {
                        System.out.println("Devi inserire prima almeno uno studente!");
                    }
                    break;

                case "5":
                    System.out.println("=== DOCENTI ===");
                    for (Docente docente : docenti) {
                        System.out.println(docente.getNome() + " - " + docente.getMateria());
                    }
                    break;

                case "6":
                    System.out.println("=== STUDENTI ===");
                    for (Studente studente : studenti) {
                        System.out.println(studente.getNome() + " - " + studente.getClasseFrequentata());
                    }
                    break;

                case "7":
                    isTrue = false;
                    return;

                default:
                    System.out.println("Scelta non valida!");
            }
        }

        scanner.close(); // Chiudo lo Scanner "scanner" e libero le risorse
    }
}
