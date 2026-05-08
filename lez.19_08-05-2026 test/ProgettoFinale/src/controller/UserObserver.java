package controller;

public class UserObserver implements Observer {
    public void update(String msg) {
        System.out.println("NOTIFICA UTENTE: " + msg);
    }
}