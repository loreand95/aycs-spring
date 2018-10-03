package it.univaq.aycs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.univaq.aycs.business.impl.repositories.CategoriaRepository;
import it.univaq.aycs.business.impl.repositories.ImmagineRepository;
import it.univaq.aycs.business.impl.repositories.IngredienteRepository;
import it.univaq.aycs.business.impl.repositories.ProdottoRepository;
import it.univaq.aycs.business.impl.repositories.UtenteRepository;

@SpringBootApplication
public class AYCSApplication {

	@Bean
	public CommandLineRunner loadData(ImmagineRepository immagineRepository, CategoriaRepository categoriaRepository,IngredienteRepository ingredienteRepository ,UtenteRepository utenteRepository, ProdottoRepository prodottoRepository) {
		return (args) -> {
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(AYCSApplication.class, args);
	}

}
