package it.uniroma3.siw.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Autore;
import it.uniroma3.siw.model.OperaArte;

public interface AutoreRepository  extends CrudRepository<Autore, Long> {
	
	public Optional<List<Autore>> findByNome(String nome);
	

}
