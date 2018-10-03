package it.univaq.aycs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CATEGORIA", nullable = false)
	private Long id;
	
	@Column(name = "NOME", nullable = false, length = 255)
	private String nome;
	
	@Column(name = "PROPRIETA", nullable = false, length = 255)
	private String proprieta;
	
	public Categoria(String nome) {
		this.nome=nome;
	}

	public Categoria() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProprieta() {
		return proprieta;
	}

	public void setProprieta(String proprieta) {
		this.proprieta = proprieta;
	}
	
}
