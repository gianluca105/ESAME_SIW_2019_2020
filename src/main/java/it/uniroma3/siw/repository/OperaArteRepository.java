package it.uniroma3.siw.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Autore;
import it.uniroma3.siw.model.OperaArte;

public interface OperaArteRepository   extends CrudRepository<OperaArte, Long>{
	
	public Optional<List<OperaArte>> findByAutore(Autore autore);

	public Optional<List<OperaArte>> findByAnno(int anno);
	
	public Optional<List<OperaArte>> findByTitolo(String titolo);
	
	public Optional<OperaArte> findById(long id);
	
}

