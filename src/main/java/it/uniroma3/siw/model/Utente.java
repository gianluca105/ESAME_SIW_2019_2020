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
	

	
	@OneToOne
	private OperaArte operaAggiunta;
	
	@OneToOne
	private Autore autoreAggiunto;
	
	

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

	


	public OperaArte getOperaAggiunta() {
		return operaAggiunta;
	}

	public void setOperaAggiunta(OperaArte operaAggiunta) {
		this.operaAggiunta = operaAggiunta;
	}

	public Autore getAutoreAggiunto() {
		return autoreAggiunto;
	}

	public void setAutoreAggiunto(Autore autoreAggiunto) {
		this.autoreAggiunto = autoreAggiunto;
	}

	

}
