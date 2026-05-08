package controller;

import java.util.*;

// Gestore degli Observer: Subject (osservato)
public class TicketService {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    // Notifica tutti gli observer
    public void notifyAllObservers(String msg) {
        for (Observer o : observers) {
            o.update(msg);
        }
    }
}