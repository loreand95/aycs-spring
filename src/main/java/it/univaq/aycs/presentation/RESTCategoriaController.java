package it.univaq.aycs.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.aycs.business.AYCService;
import it.univaq.aycs.business.impl.repositories.interfaces.NameOnly;


@RestController
@RequestMapping("/api/categorie")
public class RESTCategoriaController {
	
	@Autowired
	private AYCService service;
	
	@GetMapping("/{proprieta}")
	public List<NameOnly> listProdotti(@PathVariable String proprieta) {
		System.out.println("pro:"+proprieta);		
		return service.findCategorieByProprieta(proprieta);
	}
	

}
