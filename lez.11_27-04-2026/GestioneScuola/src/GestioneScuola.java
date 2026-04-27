import java.util.ArrayList;
import java.util.Scanner;

public class GestioneScuola {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Docente> docenti = new ArrayList<>();
        ArrayList<Studente> studenti = new ArrayList<>();
        boolean isTrue = true;

        while (isTrue) {

            System.out.println("\n===== MENU SCUOLA =====");
            System.out.println("1. Crea Docente");
            System.out.println("2. Crea Studente");
            System.out.println("3. Assegna Voto");
            System.out.println("4. Stampa Voti Studente");
            System.out.println("5. Lista Docenti");
            System.out.println("6. Lista Studenti");
            System.out.println("7. Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {

                case 1:
                    System.out.print("Nome docente: ");
                    String nomeDocente = scanner.nextLine();

                    System.out.print("Età docente: ");
                    int etaDocente = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Materia: ");
                    String materia = scanner.nextLine();

                    docenti.add(new Docente(nomeDocente, etaDocente, materia));

                    System.out.println("Docente creato!");
                    break;

                case 2:
                    System.out.print("Nome studente: ");
                    String nomeStudente = scanner.nextLine();

                    System.out.print("Età studente: ");
                    int etaStudente = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Classe: ");
                    String classe = scanner.nextLine();

                    studenti.add(new Studente(nomeStudente, etaStudente, classe));

                    System.out.println("Studente creato!");
                    break;

                case 3:
                    if (docenti.size() > 0) {
                        System.out.println("Scegli docente:");

                        for (int i = 0; i < docenti.size(); i++) {
                            System.out.println(i + " - " + docenti.get(i).getNome());
                        }
                        int d = scanner.nextInt();

                        Docente doc = docenti.get(d);

                        System.out.println("Scegli studente:");
                        if (studenti.size() > 0) {
                            for (int i = 0; i < studenti.size(); i++) {
                                if (studenti.get(i).getClasseFrequentata().contains(doc.getMateria())) {
                                    System.out.println(i + " - " + studenti.get(i).getNome());
                                }
                            }
                            int s = scanner.nextInt();

                            System.out.print("Inserisci voto: ");
                            int voto = scanner.nextInt();

                            doc.assegnaVoti(studenti.get(s), voto);
                        } else {
                            System.out.println("Devi inserire prima almeno uno studente!");
                        }
                    } else {
                        System.out.println("Devi inserire prima almeno un docente!");
                    }
                    break;

                case 4:
                    if (studenti.size() > 0) {

                        System.out.println("Scegli studente:");
                        for (int i = 0; i < studenti.size(); i++) {
                            System.out.println(i + " - " + studenti.get(i).getNome());
                        }
                        int id = scanner.nextInt();

                        studenti.get(id).stampaVoti();
                    } else {
                        System.out.println("Devi inserire prima almeno uno studente!");
                    }
                    break;

                case 5:
                    System.out.println("=== DOCENTI ===");
                    for (Docente d1 : docenti) {
                        System.out.println(d1.getNome() + " - " + d1.getMateria());
                    }
                    break;

                case 6:
                    System.out.println("=== STUDENTI ===");
                    for (Studente s1 : studenti) {
                        System.out.println(s1.getNome() + " - " + s1.getClasseFrequentata());
                    }
                    break;

                case 7:
                    isTrue = false;
                    return;

                default:
                    System.out.println("Scelta non valida!");
            }
        }

        scanner.close();
    }
}