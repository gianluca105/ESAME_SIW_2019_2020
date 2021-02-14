package it.uniroma3.siw.service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Autore;
import it.uniroma3.siw.model.OperaArte;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.repository.OperaArteRepository;

@Service
public class OperaArteService {
	
	@Autowired
	OperaArteRepository operaArteRepository;
	
	@Transactional
	public List<OperaArte> getOperaArte(Autore autore){
		Optional<List<OperaArte>> result = this.operaArteRepository.findByAutore(autore);
		return result.orElse(null);
	}
	@Transactional
	public List<OperaArte> getOperaArte(int anno){
		Optional<List<OperaArte>> result = this.operaArteRepository.findByAnno(anno);
		return result.orElse(null);
	}
	@Transactional
	public OperaArte getOperaArte(long id) {
		Optional<OperaArte> result = this.operaArteRepository.findById(id);
		return result.orElse(null);
	}
	@Transactional
	public List<OperaArte> getOperaArte(String titolo){
		Optional<List<OperaArte>> result = this.operaArteRepository.findByTitolo(titolo);
		return result.orElse(null);
	}
	
	@Transactional
    public OperaArte saveOperaArte(OperaArte operaArte) {
        return this.operaArteRepository.save(operaArte);
    }
	@Transactional
	public void deleteOperaArte(OperaArte operaArte) {
		this.operaArteRepository.delete(operaArte);
	}
	@Transactional 
	public Set<Integer> selectAnni() {
		Set<Integer> result = new HashSet<>();
		Iterable<OperaArte> iterable = this.operaArteRepository.findAll();
        for(OperaArte operaArte : iterable)
            result.add(operaArte.getAnno());
        return result;
		
		
		
	}
	@Transactional
    public List<OperaArte> getAllOpere() {
        List<OperaArte> result = new ArrayList<>();
        Iterable<OperaArte> iterable = this.operaArteRepository.findAll();
        for(OperaArte operaArte : iterable)
            result.add(operaArte);
        return result;
    }
	@Transactional
	   public void delete(long id){
	     this.operaArteRepository.deleteById(id);
	    }

}
