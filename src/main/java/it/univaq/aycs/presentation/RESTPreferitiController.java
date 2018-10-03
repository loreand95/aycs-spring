package it.univaq.aycs.presentation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.aycs.business.AYCService;
import it.univaq.aycs.business.impl.repositories.interfaces.ProdottoAnteprima;
import it.univaq.aycs.common.Utility;
import it.univaq.aycs.domain.Utente;


@RestController
@RequestMapping("/api/preferiti")
public class RESTPreferitiController {
	
	@Autowired
	private AYCService service;
	
	@GetMapping
	public List<ProdottoAnteprima> list() {
		Utente utente = Utility.getUtente();
		return service.findPreferiti(utente);
	}
	
	@GetMapping("add/{idProdotto}")
	public void addPreferito(@PathVariable Long idProdotto) {
		Utente utente = Utility.getUtente();
		service.addPreferito(idProdotto,utente.getId());
	}
	
	@DeleteMapping("/{idProdotto}")
	public void deleteAppello( @PathVariable long idProdotto) {
		Utente utente = Utility.getUtente();
		service.deletePreferito(idProdotto, utente.getId());
	}

}
