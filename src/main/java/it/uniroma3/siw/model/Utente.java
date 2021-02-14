package it.uniroma3.siw.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	private LocalDateTime dataCreazione;
	
	private LocalDateTime ultimoUpdate;

	
	@OneToOne
	private OperaArte operaModifica;
	
	@OneToMany
	private List<OperaArte> opereArte;
	
	

	public Utente() {
		
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDateTime getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(LocalDateTime dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public LocalDateTime getUltimoUpdate() {
		return ultimoUpdate;
	}

	public void setUltimoUpdate(LocalDateTime ultimoUpdate) {
		this.ultimoUpdate = ultimoUpdate;
	}

	public OperaArte getOperaModifica() {
		return operaModifica;
	}

	public void setOperaModifica(OperaArte operaModifica) {
		this.operaModifica = operaModifica;
	}

	public List<OperaArte> getOpereArte() {
		return opereArte;
	}

	public void setOpereArte(List<OperaArte> opereArte) {
		this.opereArte = opereArte;
	}

}
