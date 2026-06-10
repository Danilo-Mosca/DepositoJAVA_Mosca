package com.example.gestioneprodotti;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.gestioneprodotti.Services.ProdottoService;

@SpringBootApplication
public class GestioneprodottiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneprodottiApplication.class, args);
	}

	//Richiamo il Bean
	@Bean
	//Utilizzio CommandLinRunner per chiamare stampaCatalogo(20) e applicare lo sconto del 20%$
	CommandLineRunner runner(ProdottoService prodottoService) {
		return args -> {
			prodottoService.stampaCatalogo(20);
			prodottoService.stampaCatalogo(10);
		};
	}
}