package it.univaq.aycs.business.impl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.univaq.aycs.business.impl.repositories.interfaces.NameOnly;
import it.univaq.aycs.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	@Query(value = "SELECT e FROM Categoria e WHERE e.proprieta=?1 order by e.nome")
	List<NameOnly> findCategorieByProprieta(String proprieta);

}


