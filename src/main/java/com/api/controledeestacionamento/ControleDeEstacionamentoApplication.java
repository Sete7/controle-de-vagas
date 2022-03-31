package com.api.controledeestacionamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ControleDeEstacionamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleDeEstacionamentoApplication.class, args);

	}

	@GetMapping("/")
	public String index() {
		return "Bem vindo ao controle de vaga para apartamentos";
	}

}
