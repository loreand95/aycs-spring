package it.univaq.aycs.business.impl.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import it.univaq.aycs.domain.Ingrediente;


public interface IngredienteRepository extends JpaRepository<Ingrediente, Long>{
	
	
}
