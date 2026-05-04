// Interfaccia del Subject:
public interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void inviaNotifica(String messaggio);
}