public interface Subject {
    void registraUtente(Observer osservatore);

    void rimuoviUtente(String nomeRegistrato, String cognomeRegistrato);

    void notificaUtenti(String messaggio);
}