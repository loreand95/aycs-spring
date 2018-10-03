package it.univaq.aycs.business;

import java.util.List;

import it.univaq.aycs.business.impl.repositories.interfaces.NameOnly;
import it.univaq.aycs.business.impl.repositories.interfaces.ProdottoAnteprima;
import it.univaq.aycs.domain.Categoria;
import it.univaq.aycs.domain.Prodotto;
import it.univaq.aycs.domain.Utente;

public interface AYCService {

	Utente findUtenteByUsername(String username) throws BusinessException;
	
	void createUtente(Utente utente) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;

	Prodotto findProdottoById(Long id) throws BusinessException;
	
	List<Prodotto> findAllProdotti(Utente utente) throws BusinessException;
	
	List<Categoria> findAllCategorie() throws BusinessException;

	List<ProdottoAnteprima> findPreferiti(Utente utente) throws BusinessException;
	
	List<ProdottoAnteprima>  findAllProdottiByCategoria(String categoria) throws BusinessException;
	
	void deletePreferito(long idProdotto,long idUtente) throws BusinessException;

	void addPreferito(long idProdotto,long idUtente) throws BusinessException;

	List<NameOnly> findCategorieByProprieta(String proprieta);

	List<Prodotto> findBySelezione();

}
