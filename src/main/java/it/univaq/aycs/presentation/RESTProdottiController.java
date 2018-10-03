package it.univaq.aycs.presentation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.univaq.aycs.business.AYCService;
import it.univaq.aycs.business.impl.repositories.interfaces.ProdottoAnteprima;
import it.univaq.aycs.domain.Prodotto;



@RestController
@RequestMapping("/api/prodotti")
public class RESTProdottiController {
	
	@Autowired
	private AYCService service;
	
	
	@GetMapping("/categoria/{categoria}")
	public List<ProdottoAnteprima> listProdottiCategoria(@PathVariable String categoria) {
		return service.findAllProdottiByCategoria(categoria);
	}
	
	@GetMapping("/categoria/selezione")
	public List<Prodotto> listSelezione() {
		return service.findBySelezione();
	}
	

	@GetMapping("/prodotto/{id}")
	public Prodotto findById(@PathVariable Long id) {
		return service.findProdottoById(id);
	}
	

}
