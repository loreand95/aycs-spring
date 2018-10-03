package it.univaq.aycs.business.impl.repositories.interfaces;

import java.util.Set;

import it.univaq.aycs.domain.Immagine;

public interface ProdottoAnteprima {
	
	Long getId();
	String getNome();
	float getPrezzo();
	Set<Immagine> getPreview();

}
