package it.univaq.aycs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "immagine")
public class Immagine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_IMMAGINE", nullable = false)
	private Long id;
	
	@Column(name = "NOME", nullable = false, length = 255)
	private String nome;
	
	@Column(name = "TIPO", nullable = true, length = 255)
	private String tipo;
	
	@Column(name = "PERCORSO", nullable = false, columnDefinition="TEXT")
	private String percorso;
	
	@ManyToOne
	@JoinColumn(name="PRODOTTO_ID", nullable=false)
	private Prodotto prodotto;
	
	public Immagine(String nome,String tipo, String percorso, Prodotto prodotto) {
		this.nome=nome;
		this.tipo=tipo;
		this.percorso=percorso;
		this.prodotto = prodotto;
	}

	public Immagine() {
		
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
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getPercorso() {
		return percorso;
	}

	public void setPercorso(String percorso) {
		this.percorso = percorso;
	}

	
	
	
}
