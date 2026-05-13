package com.example.gestioneprodotti.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class ProdottoService {
    List<String> nomiProdotti = new ArrayList<>();
    Map<String, Double> prezzi = new HashMap<>();

    private final PrezzoService prezzoService; // variabile final perché sarà iniettata alla costruzione della classe
                                               // dal costruttore

    // Costruttore
    // Dependency Injection via costruttore
    public ProdottoService(PrezzoService prezzoService) {
        this.prezzoService = prezzoService;
    }

    // Annotazione che richiama il seguente metodo subito dopo la costruzione del
    // Bean, dopo il Costruttore
    @PostConstruct
    public void init() {
        // Inserisco i prodotti
        nomiProdotti.add("Apple iPad");
        nomiProdotti.add("HP stampande");
        nomiProdotti.add("Monitor HP");

        // Inserisco i prezzi nel map (chiave -> valore)
        prezzi.put("Apple iPad", 499.99);
        prezzi.put("HP stampande", 149.99);
        prezzi.put("Monitor HP", 199.99);
    }

    // Metodo che stampa ogni prodotto con il prezzo scontato
    public void stampaCatalogo(int percentualeSconto) {
        System.out.println("================================================================");
        System.out.println("================ CATALOGO PRODOTTI - Sconto: 20% ===============");
        System.out.println("================================================================");

        // Ciclo con un foreach per restituire tutti i prodotti con i prezzo scontato
        for (String prodotto : nomiProdotti) {
            double prezzoSenzaSconto = prezzi.get(prodotto);

            double prezzoScontato = prezzoService.calcolaPrezzoScontato(prezzoSenzaSconto, percentualeSconto);
            System.out.println(prodotto + ": " + prezzoSenzaSconto + " -> " + prezzoScontato + " prezzo scontato");
        }
        System.out.println("================================================================");
    }

}
