package it.univaq.aycs.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.univaq.aycs.business.BusinessException;
import it.univaq.aycs.business.AYCService;
import it.univaq.aycs.business.impl.repositories.CategoriaRepository;
import it.univaq.aycs.business.impl.repositories.ProdottoRepository;
import it.univaq.aycs.business.impl.repositories.UtenteRepository;
import it.univaq.aycs.business.impl.repositories.interfaces.NameOnly;
import it.univaq.aycs.business.impl.repositories.interfaces.ProdottoAnteprima;
import it.univaq.aycs.domain.Categoria;
import it.univaq.aycs.domain.Prodotto;
import it.univaq.aycs.domain.Utente;;


@Service
@Transactional
public class AYCServiceImpl implements AYCService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private ProdottoRepository prodottoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public Utente findUtenteByUsername(String username) throws BusinessException {
		return utenteRepository.findByUsername(username);
	}

	@Override
	public List<ProdottoAnteprima> findPreferiti(Utente utente) throws BusinessException {
		return prodottoRepository.findIdandNomeByPreferiti_Id(utente.getId());
	}
	
	@Override
	public Prodotto findProdottoById(Long id) throws BusinessException {
		return prodottoRepository.findById(id).get();
	}
	
	@Override
	public Utente updateProfilo(Utente profilo) throws BusinessException {
		Utente utente = utenteRepository.findByUsername(profilo.getUsername());
		utente.setEmail(profilo.getEmail());
		
		return utente;
	}

	@Override
	public void createUtente(Utente utente) throws BusinessException {
		Utente emailExist = utenteRepository.findByEmail(utente.getEmail());
		Utente userExist = utenteRepository.findByUsername(utente.getUsername());
		
		if(emailExist!=null) {
			throw new BusinessException("email exist");
		}
		
		if(userExist!=null) {
			throw new BusinessException("user exist");
		}
		
		utente.setPassword(passwordEncoder.encode(utente.getPassword()));
		utenteRepository.save(utente);
		
	}

	@Override
	public List<Prodotto> findAllProdotti(Utente utente) throws BusinessException {
		return prodottoRepository.findAllProdotti();
	}

	@Override
	public List<Categoria> findAllCategorie() throws BusinessException {
		return categoriaRepository.findAll();
	}
	
	@Override
	public void deletePreferito(long idProdotto,long idUtente) throws BusinessException {	
		prodottoRepository.deleteByPreferitiId(idProdotto,idUtente);
	}

	@Override
	public void addPreferito(long idProdotto,long idUtente) throws BusinessException {
		prodottoRepository.addPreferitiId(idProdotto,idUtente);
	}

	@Override
	public List<ProdottoAnteprima> findAllProdottiByCategoria(String categoria) throws BusinessException {
		return prodottoRepository.findAllProdottiByCategoria(categoria);
	}

	@Override
	public List<NameOnly> findCategorieByProprieta(String proprieta) {
		return categoriaRepository.findCategorieByProprieta(proprieta);
	}

	@Override
	public List<Prodotto> findBySelezione() {
		return prodottoRepository.findBySelezione();
	}
	
}
