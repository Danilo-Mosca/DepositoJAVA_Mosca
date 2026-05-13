package com.example.gestioneprodotti.Services;

import org.springframework.stereotype.Service;

@Service
public class PrezzoService {
    public double calcolaPrezzoScontato(double prezzoOriginale, int percentualeSconto) {
        double sconto = (prezzoOriginale * percentualeSconto) / 100;
        return prezzoOriginale - sconto;
    }
}
