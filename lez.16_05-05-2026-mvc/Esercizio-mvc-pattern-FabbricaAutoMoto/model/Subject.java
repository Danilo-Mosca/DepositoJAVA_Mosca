package model;
// Interfaccia Subject (pattern Observer) per l'osservato, ovvero per la classe S_Fabbrica
public interface Subject {
    void addObserver(Observer observer);

    void notifyObservers(String messaggio);
}