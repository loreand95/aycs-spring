package it.univaq.aycs.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "prodotti")
public class Prodotto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODOTTO", nullable = false)
	private Long id;
	
	@Column(name = "NOME", nullable = false, length = 255)
	private String nome;
	
	@Column(name = "DESCRIZIONE", nullable = false, length = 255)
	private String descrizione;
	
	@Column(name = "PREZZO", nullable = true, length = 255)
	private float prezzo;
	
	public Prodotto(String nome, String descr, float prezzo) {
		this.nome=nome;
		this.descrizione=descr;
		this.prezzo=prezzo;
	}
	
	@ManyToMany
	@JoinTable(name="PRODOTTI_CATEGORIE",
	    joinColumns={@JoinColumn(name="ID_PRODOTTO")},
	    inverseJoinColumns={@JoinColumn(name="ID_CATEGORIA")})
	private Set<Categoria> categorie = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="PRODOTTI_INGREDIENTI",
	    joinColumns={@JoinColumn(name="ID_PRODOTTO")},
	    inverseJoinColumns={@JoinColumn(name="ID_INGREDIENTI")})
	private Set<Ingrediente> ingredienti = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="PRODOTTI_UTENTI",
	    joinColumns={@JoinColumn(name="ID_PRODOTTO")},
	    inverseJoinColumns={@JoinColumn(name="ID_UTENTE")})
	private Set<Utente> preferiti = new HashSet<>();
	
	@OneToMany(mappedBy="prodotto")
	@Where(clause="tipo<>'preview'")
	private Set<Immagine> immagini = new HashSet<>();
	
	@OneToMany(mappedBy="prodotto")
	@Where(clause="tipo='preview'")
	private Set<Immagine> preview = new HashSet<>();

	
	public Set<Immagine> getPreview() {
		return preview;
	}

	public void setPreview(Set<Immagine> preview) {
		this.preview = preview;
	}

	public Prodotto() {
		
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	public Set<Utente> getPreferiti() {
		return preferiti;
	}
	public void setPreferiti(Set<Utente> preferiti) {
		this.preferiti = preferiti;
	}
	
	public Set<Ingrediente> getIngredienti() {
		return ingredienti;
	}
	public void setIngredienti(Set<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}
	
	public Set<Categoria> getCategorie() {
		return categorie;
	}
	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}
	
	public Set<Immagine> getImmagini() {
		return immagini;
	}
	public void setImmagini(Set<Immagine> immagini) {
		this.immagini = immagini;
	}
	

	

}
