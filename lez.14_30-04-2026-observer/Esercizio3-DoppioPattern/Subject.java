// Interfaccia del Subject:
public interface Subject {
    void registraUtente(Observer osservatore);

    void rimuoviUtente(Observer osservatore);

    void notificaUtenti(String messaggio);
}