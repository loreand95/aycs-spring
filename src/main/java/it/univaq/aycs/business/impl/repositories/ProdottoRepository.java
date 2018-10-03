package it.univaq.aycs.business.impl.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import it.univaq.aycs.business.impl.repositories.interfaces.ProdottoAnteprima;
import it.univaq.aycs.domain.Prodotto;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long>{
	
//	static final String CONST = "Selezione";
	
	List<ProdottoAnteprima> findIdandNomeByPreferiti_Id(Long id);

	@Query(value = "SELECT * FROM prodotti", nativeQuery = true)
	List<Prodotto> findAllProdotti();
	
	@Modifying
	@Query(value = "delete from prodotti_utenti where prodotti_utenti.id_prodotto = ? and prodotti_utenti.id_utente = ?", nativeQuery = true)
	void deleteByPreferitiId(long idPreferito,long idUtente);
	
	@Modifying
	@Query(value = "INSERT IGNORE prodotti_utenti(id_prodotto, id_utente) VALUES (?, ?);", nativeQuery = true)
	void addPreferitiId(long idPreferito,long idUtente);
	
	@Query(value = "SELECT p FROM Prodotto as p LEFT JOIN p.categorie c WHERE c.nome=?1")
	List<ProdottoAnteprima> findAllProdottiByCategoria(String categoria);

	@Query(value = "SELECT p FROM Prodotto as p LEFT JOIN p.categorie c WHERE c.nome='Selezione'")
	List<Prodotto> findBySelezione();
	
}
