package controller;

public class AdminObserver implements Observer {
    public void update(String msg) {
        System.out.println("NOTIFICA ADMIN: " + msg);
    }
}